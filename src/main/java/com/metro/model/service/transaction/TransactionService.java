package com.metro.model.service.transaction;

import com.metro.model.exceptions.InsufficientBalanceException;
import com.metro.model.exceptions.InvalidStationException;
import com.metro.model.exceptions.InvalidSwipeInException;
import com.metro.model.exceptions.InvalidSwipeOutException;
import com.metro.model.persistence.card.CardDaoInterface;
import com.metro.model.persistence.station.StationDaoInterface;
import com.metro.model.persistence.transaction.TransactionDaoInterface;
import com.metro.model.pojos.Station;
import com.metro.model.pojos.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("transactionService")
public class TransactionService implements TransactionServiceInterface {
    TransactionDaoInterface transactionDao;
    CardDaoInterface cardDao;
    StationDaoInterface stationDao;

    @Autowired
    @Qualifier("transactionDao")
    public void setTransactionDao(TransactionDaoInterface transactionDao) {
        this.transactionDao = transactionDao;
    }

    @Autowired
    @Qualifier("cardDao")
    public void setCardDao(CardDaoInterface cardDao) {
        this.cardDao = cardDao;
    }

    @Autowired
    @Qualifier("stationDao")
    public void setStationDao(StationDaoInterface stationDao) {
        this.stationDao = stationDao;
    }

    @Override
    public Collection<Transaction> getAllTransactions(int cardId)  {
        return transactionDao.getAllTransactions(cardId);
    }

    public Collection<Transaction> getAllFines()  {
        return transactionDao.getAllFines();
    }

    @Override
    public String swipeIn(int cardId, int sourceStationId) throws InsufficientBalanceException, InvalidStationException, InvalidSwipeInException {
        if(stationDao.isAStation(sourceStationId)) {
            if(cardDao.getCardDetails(cardId).getBalance() >= 20) {
                Transaction lastTransaction =  transactionDao.getLastTransaction(cardId);
                if (lastTransaction == null || lastTransaction.getDestinationStation() != null) {
                    transactionDao.createTransaction(new Transaction(cardId, new Station(sourceStationId)));
                    return stationDao.getStation(sourceStationId);
                }
                else throw new InvalidSwipeInException();
            } else throw new InsufficientBalanceException();
        } else throw new InvalidStationException();

    }

    @Override
    public Transaction swipeOut(int cardId, int destinationStationId) throws InvalidSwipeOutException, InvalidStationException {
        if(stationDao.isAStation(destinationStationId)){
            Transaction lastTransaction =  transactionDao.getLastTransaction(cardId);
            if (lastTransaction.getSourceStation() != null && lastTransaction.getDestinationStation() == null) {
                transactionDao.setDestinationStation(destinationStationId, lastTransaction.getTransactionId());
                int fare = TransactionServiceHelper.calculateFare(lastTransaction.getSourceStation(), new Station(destinationStationId));
                int fine = getFine(lastTransaction.getTransactionId());
                fare += fine;
                int duration = transactionDao.getTransactionDuration(lastTransaction.getTransactionId());
                if (transactionDao.completeTransaction(new Transaction(lastTransaction.getTransactionId(),fare,fine,duration)))
                    cardDao.chargeCard(cardId, fare);
            } else throw new InvalidSwipeOutException();
        } else throw new InvalidStationException();
        return transactionDao.getLastTransaction(cardId);
    }

    public int getFine(int transactionId) {
        int duration =  transactionDao.getTransactionDuration(transactionId);
        int extraHours;
        if (duration >= 0) {
            if(duration == 0) return 0;
            if(duration - 90 > 0 ) {
                int extraMinutes = duration - 90;
                if(extraMinutes % 60 == 0) {
                    extraHours = extraMinutes / 60;
                } else {
                    extraHours = 1 + extraMinutes / 60;
                }
                return extraHours * 100;
            } else return 0;
        }else return -1;
    }
}
