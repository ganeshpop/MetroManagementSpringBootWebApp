package com.metro.model.persistence.card;

import com.metro.model.pojos.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cardDao")
public class CardDao implements CardDaoInterface {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean addCard(Card card) {
        int affectedRows = jdbcTemplate.update("INSERT INTO cards(card_type, balance, active_since) VALUE(?,?,SYSDATE())", card.getCardType(), card.getBalance());
        return (affectedRows > 0);
    }

    @Override
    public boolean isACard(int cardId) {
        try {
            Integer retrievedCardId = jdbcTemplate.queryForObject("SELECT card_id FROM cards WHERE card_id = ?", Integer.class, cardId);
            return retrievedCardId != null;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public Card getCardDetails(int cardId) {
        List<Card> cards = jdbcTemplate.query("SELECT * FROM cards WHERE card_id = ?", new CardRowMapper(), cardId);
        return cards.get(0);
    }

    @Override
    public boolean rechargeCard(int cardId, int amount) {
        int affectedRows = jdbcTemplate.update("UPDATE cards SET balance = balance + ? WHERE card_id = ?;", amount, cardId);
        return (affectedRows > 0);
    }

    @Override
    public boolean chargeCard(int cardId, int amount) {
        int affectedRows = jdbcTemplate.update("UPDATE cards SET balance = balance - ? WHERE card_id = ?;", amount, cardId);
        return (affectedRows > 0);
    }

    @Override
    public int getNewCardId() {
        try {
            Integer retrievedCardId = jdbcTemplate.queryForObject("SELECT card_id FROM cards ORDER BY card_id DESC LIMIT 1;", Integer.class);
            if(retrievedCardId != null) return retrievedCardId;
        } catch (EmptyResultDataAccessException e) {
            return -1;
        }
        return -1;
    }

    @Override
    public boolean setPassword(int cardId, String password) {
        int affectedRows = jdbcTemplate.update("UPDATE cards SET password =  ? WHERE card_id = ?;", password, cardId);
        return (affectedRows > 0);
    }

    @Override
    public boolean validatePassword(int cardId, String password) {
        try {
            Integer retrievedCardId = jdbcTemplate.queryForObject("SELECT card_id FROM cards WHERE card_id = ? AND  password = ?;", Integer.class, cardId, password);
            return retrievedCardId != null;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }


}
