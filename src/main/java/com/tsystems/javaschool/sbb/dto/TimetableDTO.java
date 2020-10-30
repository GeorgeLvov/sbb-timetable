package com.tsystems.javaschool.sbb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.json.bind.annotation.JsonbDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableDTO {

    private String trainName;

    private String stationFrom;

    private String stationTo;

    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date departureTime;

    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date arrivalTime;

    private int delay;

    private boolean canceled;

}
