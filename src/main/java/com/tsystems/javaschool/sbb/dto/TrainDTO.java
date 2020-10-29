package com.tsystems.javaschool.sbb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainDTO {
    private int id;
    private String trainName;
    private int capacity;

}
