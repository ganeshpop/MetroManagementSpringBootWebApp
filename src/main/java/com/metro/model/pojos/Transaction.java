package com.metro.model.pojos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

@ToString
@NoArgsConstructor
@Getter
public class Transaction {
    private  int cardId;
    private  int transactionId;
    private  Station sourceStation;
    private  Station destinationStation;
    private  int fare;
    private int fine;
    private Timestamp swipeInTimeStamp;
    private Timestamp swipeOutTimeStamp;
    private int duration;

    public Transaction(int cardId, int transactionId, Station sourceStation, Station destinationStation, int fare,int fine, Timestamp swipeInTimeStamp, Timestamp swipeOutTimeStamp, int duration) {
        this.cardId = cardId;
        this.transactionId = transactionId;
        this.sourceStation = sourceStation;
        this.destinationStation = destinationStation;
        this.fare = fare;
        this.fine = fine;
        this.swipeInTimeStamp = swipeInTimeStamp;
        this.swipeOutTimeStamp = swipeOutTimeStamp;
        this.duration = duration;

    }

    public Transaction(int transactionId, int fare, int fine,int duration) {
        this.transactionId = transactionId;
        this.fare = fare;
        this.fine = fine;
        this.duration = duration;
    }

    public Transaction(int cardId, Station sourceStation){
        this.cardId = cardId;
        this.sourceStation = sourceStation;
    }

    public Transaction(int fine) {
        this.fine = fine;
    }
}
