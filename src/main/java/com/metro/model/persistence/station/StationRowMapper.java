package com.metro.model.persistence.station;

import com.metro.model.pojos.Station;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StationRowMapper implements RowMapper<Station> {

    @Override
    public Station mapRow(ResultSet resultSet, int i) throws SQLException {
        Station station = new Station(resultSet.getInt("station_id"),resultSet.getString("station_name"));
        return station;
    }
}
