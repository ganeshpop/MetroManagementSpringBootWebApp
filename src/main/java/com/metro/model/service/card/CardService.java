package com.metro.model.service.card;

import com.metro.model.persistence.card.CardDaoInterface;
import com.metro.model.pojos.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("cardService")

public class CardService implements  CardServiceInterface{
    CardDaoInterface cardDao;


    @Autowired
    @Qualifier("cardDao")
    public void setCardDao(CardDaoInterface cardDao) {
        this.cardDao = cardDao;
    }

    @Override
    public int getBalance(int cardId) {
        if(cardDao.getCardDetails(cardId) == null) return -1;
        return cardDao.getCardDetails(cardId).getBalance();
    }
    @Override
    public int addCard(Card card) {
        if(cardDao.addCard(card)){
            return cardDao.getNewCardId();
        }
        return -1;
    }
    @Override
    public Card getCardDetails(int cardId)  {
        return cardDao.getCardDetails(cardId);
    }

    @Override
    public boolean isACard(int cardId){
        return cardDao.isACard(cardId);
    }

    @Override
    public boolean setPassword(int cardId, String password) {
        return cardDao.setPassword(cardId,password);
    }

    @Override
    public boolean validatePassword(int cardId, String password) {
        return cardDao.validatePassword(cardId, password);
    }

    @Override
    public boolean rechargeCard(int cardId, int amount) {
        if(amount > 0) return cardDao.rechargeCard(cardId, amount);
        else return false;
    }
}
