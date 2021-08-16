package com.metro.model.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Station {
    @NonNull
    private final int stationId;
    private String stationName;

    public String toString(){
        return "[Station ID: "+stationId +" Station Name: "+stationName +"]";
    }
}
