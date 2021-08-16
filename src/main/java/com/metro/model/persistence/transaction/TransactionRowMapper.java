package com.metro.model.persistence.transaction;

import com.metro.model.pojos.Station;
import com.metro.model.pojos.Transaction;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

@Component
public class TransactionRowMapper implements RowMapper<Transaction> {


    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        int transactionId = resultSet.getInt("transaction_id");
        int cardId = resultSet.getInt("card_id");
        Station sourceStation = (resultSet.getString("source_station_id") != null) ? new Station(resultSet.getInt("source_station_id"), resultSet.getString("source_station_name")) : null;
        Station destinationStation = (resultSet.getString("destination_station_id") != null) ? new Station(resultSet.getInt("destination_station_id"), resultSet.getString("destination_station_name")) : null;
        int fare = resultSet.getInt("fare");
        int fine = resultSet.getInt("fine");
        Timestamp swipeInTimeStamp = resultSet.getTimestamp("swipe_in_time_stamp");
        Timestamp swipeOutTimeStamp = resultSet.getTimestamp("swipe_out_time_stamp");
        int duration = resultSet.getInt("duration");

        return new Transaction(cardId, transactionId, sourceStation, destinationStation, fare, fine, swipeInTimeStamp, swipeOutTimeStamp, duration);
    }
}
