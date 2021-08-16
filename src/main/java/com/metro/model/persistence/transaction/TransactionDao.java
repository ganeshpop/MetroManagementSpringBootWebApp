package com.metro.model.persistence.transaction;

import com.metro.model.pojos.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("transactionDao")
public class TransactionDao implements TransactionDaoInterface{

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Transaction> getAllTransactions(int cardId) {
        return jdbcTemplate.query("SELECT t.transaction_id, t.card_id, t.source_station_id, s.station_name AS source_station_name, t.destination_station_id, d.station_name AS destination_station_name, t.fare, t.fine, t.swipe_in_time_stamp, t.swipe_out_time_stamp, t.duration FROM transactions t LEFT JOIN stations s ON t.source_station_id = s.station_id LEFT JOIN stations d ON t.destination_station_id = d.station_id WHERE t.card_id = ?;", new TransactionRowMapper(), cardId );
    }

    @Override
    public Collection<Transaction> getAllFines() {
        return jdbcTemplate.query("SELECT DISTINCT fine from transactions;", new TransactionFineMapper());
    }

    @Override
    public boolean setDestinationStation(int stationId, int transactionId) {
        int affectedRows = jdbcTemplate.update("UPDATE transactions SET destination_station_id = ?, swipe_out_time_stamp = (SYSDATE() + INTERVAL 15 MINUTE) WHERE transaction_id = ?;", stationId, transactionId);
        //int affectedRows = jdbcTemplate.update("UPDATE transactions SET destination_station_id = ?, swipe_out_time_stamp = (SYSDATE() + INTERVAL 200 MINUTE) WHERE transaction_id = ?;", stationId, transactionId);
        return (affectedRows > 0);
    }

    @Override
    public Transaction getLastTransaction(int cardId) {
        List<Transaction> transactions = jdbcTemplate.query("SELECT t.transaction_id, t.card_id, t.source_station_id, s.station_name AS source_station_name, t.destination_station_id, d.station_name AS destination_station_name, t.fare, t.fine, t.swipe_in_time_stamp, t.swipe_out_time_stamp, t.duration FROM transactions t LEFT JOIN stations s ON t.source_station_id = s.station_id LEFT JOIN stations d ON t.destination_station_id = d.station_id WHERE card_id = ? ORDER BY transaction_id DESC LIMIT 1;", new TransactionRowMapper(), cardId );
        if (transactions.size() > 0)
            return transactions.get(0);
        else return null;
    }

    @Override
    public int getTransactionDuration(int transactionId) {
        Integer duration = jdbcTemplate.queryForObject("SELECT TIMESTAMPDIFF(MINUTE , swipe_in_time_stamp, swipe_out_time_stamp) AS duration FROM transactions WHERE transaction_id = ?;", Integer.class, transactionId);
        if (duration != null) {
            return duration;
        }
        return -1;
    }
    @Override
    public boolean createTransaction(Transaction transaction) {
        int affectedRows = jdbcTemplate.update("INSERT INTO transactions(card_id, source_station_id, swipe_in_time_stamp) VALUE (?, ?, SYSDATE());", transaction.getCardId(), transaction.getSourceStation().getStationId());
        return (affectedRows > 0);
    }

    @Override
    public boolean completeTransaction(Transaction transaction) {
        int affectedRows = jdbcTemplate.update("UPDATE transactions SET fare = ?, fine = ?, duration = ? WHERE transaction_id = ?;", transaction.getFare(), transaction.getFine(), transaction.getDuration(),  transaction.getTransactionId());
        return (affectedRows > 0);
    }
}
