package com.tsystems.javaschool.sbb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableDTO {

    private String trainName;

    private String stationFrom;

    private String stationTo;

    private Date departureTime;

    private Date arrivalTime;

    private int delay;

    private boolean canceled;

}
