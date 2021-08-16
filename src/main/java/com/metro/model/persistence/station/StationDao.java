package com.metro.model.persistence.station;

import com.metro.model.pojos.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository("stationDao")
public class StationDao implements StationDaoInterface{

    private JdbcTemplate jdbcTemplate;



    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Station> getAllStations() {
        List<Station> stations = jdbcTemplate.query("SELECT * FROM stations;", new StationRowMapper());
        return stations;
    }

    @Override
    public boolean isAStation(int stationId) {
        try {
            Integer retrievedStationId = jdbcTemplate.queryForObject("SELECT station_id FROM stations WHERE station_id = ?;", Integer.class, stationId);
            return retrievedStationId != null;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public String getStation(int stationId) {
        try {
            return jdbcTemplate.queryForObject("SELECT station_name FROM stations WHERE station_id = ?", String.class, stationId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }
}
