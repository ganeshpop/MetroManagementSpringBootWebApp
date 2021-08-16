package com.metro.model.persistence.station;

import com.metro.model.pojos.Station;

import java.util.Collection;

public interface StationDaoInterface {
    Collection<Station> getAllStations();
    boolean isAStation(int stationId);
    String getStation(int stationId);
}
