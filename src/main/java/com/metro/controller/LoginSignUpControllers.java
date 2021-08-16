package com.metro.controller;

import com.metro.model.pojos.Card;
import com.metro.model.pojos.Transaction;
import com.metro.model.service.card.CardService;
import com.metro.model.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.stream.Collectors;


@Controller
@SessionAttributes("card")
public class LoginSignUpControllers {
    CardService cardService;
    TransactionService transactionService;

    @ModelAttribute("user")
    public Card setSession(Card card) {
        return card;
    }

    @Autowired
    @Qualifier("transactionService")
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Autowired
    @Qualifier("cardService")
    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    @RequestMapping("login")
    public ModelAndView loginController() {
        return new ModelAndView("metroLogin");
    }

    @RequestMapping("signup")
    public ModelAndView signupController() {
        return new ModelAndView("metroSignUp");
    }



    @RequestMapping("verifyCard")
    public ModelAndView verifyController(@RequestParam("card") String cardId, @RequestParam("password") String  password ) {
        ModelAndView modelAndView = new ModelAndView();
        if (cardId.matches("[0-9]+")) {
            int intCardId = Integer.parseInt(cardId);
            if (cardService.isACard(intCardId)) {
                if (cardService.validatePassword(intCardId, password)) {
                    modelAndView.addObject("cardId", cardId);
                    modelAndView.addObject("message", "You Are Logged In");
                    modelAndView.addObject("card", cardService.getCardDetails(intCardId));
                    modelAndView.setViewName("metroMenu");
                    setSession(cardService.getCardDetails(intCardId));
                    return modelAndView;
                } else return new ModelAndView("metroLoginOutput","message", "Invalid Password, Try Again");
            } else return new ModelAndView("metroLoginOutput","message", "Invalid Card");
        } else return new ModelAndView("metroLoginOutput","message", "Card ID Only Contains Integers");

    }


    @RequestMapping("createCard")
    public ModelAndView createController(@RequestParam("cardBalance") String initialBalance, @RequestParam("initialPassword") String passwordOne, @RequestParam("conformationPassword") String passwordTwo) {
        ModelAndView modelAndView = new ModelAndView();
        if (initialBalance.matches("[0-9]+")) {
            if (Integer.parseInt(initialBalance) >= 100) {
                if (passwordOne.equals(passwordTwo)) {
                    int intCardId = cardService.addCard(new Card("Basic",Integer.parseInt(initialBalance)));
                    if (intCardId > 0) {
                        if (cardService.setPassword(intCardId, passwordOne)) {
                            modelAndView.addObject("message", "Card Created Successfully, Your Card ID is " + intCardId + " Now You Can Use Metro Services");
                            modelAndView.addObject("card", cardService.getCardDetails(intCardId));
                            setSession(cardService.getCardDetails(intCardId));
                            modelAndView.setViewName("metroMenu");
                        }
                        return modelAndView;
                    } else return new ModelAndView("createCardOutput","message", "Card Creation Failed");
                } else return new ModelAndView("createCardOutput","message", "Passwords Didnt Match, Try Again");
            } else return new ModelAndView("createCardOutput","message", "Minimum Card Balance for New Users is 100/- ");
        } else return new ModelAndView("createCardOutput","message", "Only Integers Allowed");
    }

    @RequestMapping("getFines")
    public ModelAndView getFineController(){
        return new ModelAndView("metroFine","command", new Transaction());


    }
    /* Temp */
    @ModelAttribute("fines")
    public List<Integer> getFines() {
        return transactionService.getAllFines().stream().map(Transaction::getFine).collect(Collectors.toList());
    }



}
