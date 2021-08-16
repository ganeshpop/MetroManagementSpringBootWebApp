package com.metro.model.persistence.transaction;

import com.metro.model.pojos.Transaction;

import java.util.Collection;

public interface TransactionDaoInterface {

    Collection<Transaction> getAllTransactions(int cardId);
    Collection<Transaction> getAllFines();
    boolean setDestinationStation(int stationId, int transactionId);
    Transaction getLastTransaction(int cardId);
    int getTransactionDuration(int transactionId);
    boolean createTransaction(Transaction transaction);
    boolean completeTransaction(Transaction transaction);
}
