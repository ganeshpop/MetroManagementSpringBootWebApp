package com.metro.model.persistence.card;

import com.metro.model.pojos.Card;


public interface CardDaoInterface {

    boolean addCard(Card card);
    int getNewCardId();
    boolean rechargeCard(int cardId, int amount);
    boolean chargeCard(int cardId, int amount);
    Card getCardDetails(int cardId);
    boolean isACard(int cardId);
    boolean setPassword(int cardId, String password);
    boolean validatePassword(int cardId, String password);
}
