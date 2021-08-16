package com.metro.model.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

@Getter
@AllArgsConstructor
@NoArgsConstructor


public class Card {
    private int cardId;
    private String cardType;
    @Min(value = 1, message = "Must Be Equal or Greater than 1")
    @Max(value = 1000, message = "Must Be Equal or Less Than 1000")
    private int balance;
    private Timestamp activeSince;

    public Card(String cardType, int balance) {
        this.cardType = cardType;
        this.balance = balance;

    }

}
