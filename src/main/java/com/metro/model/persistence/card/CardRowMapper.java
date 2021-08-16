package com.metro.model.persistence.card;

import com.metro.model.pojos.Card;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CardRowMapper  implements RowMapper<Card> {

    @Override
    public Card mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Card(resultSet.getInt("card_id"),resultSet.getString("card_type"),resultSet.getInt("balance"),resultSet.getTimestamp("active_since"));
    }
}
