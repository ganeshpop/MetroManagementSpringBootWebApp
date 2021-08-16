package com.metro.model.persistence.transaction;

import com.metro.model.pojos.Transaction;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TransactionFineMapper implements RowMapper<Transaction> {


    @Override
    public Transaction mapRow(ResultSet resultSet, int i) throws SQLException {
        int fine = resultSet.getInt("fine");

        return new Transaction(fine);
    }
}
