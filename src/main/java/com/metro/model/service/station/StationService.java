package com.metro.model.service.station;

import com.metro.model.persistence.station.StationDaoInterface;
import com.metro.model.pojos.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("stationService")
public class StationService implements StationServiceInterface{
    StationDaoInterface stationDao;

    @Autowired
    @Qualifier("stationDao")
    public void setStationDao(StationDaoInterface stationDao) {
        this.stationDao = stationDao;
    }

    @Override
    public Collection<Station> getAllStations() {
        return stationDao.getAllStations();
    }
}
