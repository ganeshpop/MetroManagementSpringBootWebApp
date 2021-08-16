package com.metro.model.service.transaction;

import com.metro.model.exceptions.InsufficientBalanceException;
import com.metro.model.exceptions.InvalidStationException;
import com.metro.model.exceptions.InvalidSwipeInException;
import com.metro.model.exceptions.InvalidSwipeOutException;
import com.metro.model.pojos.Transaction;

import java.util.Collection;

public interface TransactionServiceInterface {
    Collection<Transaction> getAllFines();
    Collection<Transaction> getAllTransactions(int cardId);
    String swipeIn(int cardId, int sourceStationId) throws InsufficientBalanceException, InvalidStationException, InvalidSwipeInException;
    Transaction swipeOut(int cardId, int destinationStationId) throws InvalidSwipeOutException, InvalidStationException;
}
