package com.metro.model.service.card;

import com.metro.model.pojos.Card;


public interface CardServiceInterface {
        int getBalance(int cardId);
    int addCard(Card card);
    Card getCardDetails(int cardId);
    boolean isACard(int cardId);
    boolean setPassword(int cardId, String password);
    boolean validatePassword(int cardId, String password);
    boolean rechargeCard(int cardId, int amount);

}
