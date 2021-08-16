package com.metro.model.service.transaction;

import com.metro.model.pojos.Station;

public class TransactionServiceHelper {
    public static int calculateFare(Station source, Station destination) {
        if(source.getStationId() > destination.getStationId()){
            return (source.getStationId() - destination.getStationId()) * 5;
        }
        else {
            return (destination.getStationId() - source.getStationId()) * 5;
        }
    }

}
