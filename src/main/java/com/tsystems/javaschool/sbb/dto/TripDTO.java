package com.tsystems.javaschool.sbb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {

    private int id;

    private TrainDTO trainDTO;

    private StationDTO departureStationDTO;

    private StationDTO arrivalStationDTO;

    private Timestamp departureTime;

    private Timestamp arrivalTime;

    private int delay;

    private boolean canceled;

}
