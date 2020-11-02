package com.tsystems.javaschool.sbb.ejb;

import com.tsystems.javaschool.sbb.dto.StationDTO;
import com.tsystems.javaschool.sbb.dto.TimetableDTO;
import com.tsystems.javaschool.sbb.service.TimetableService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@Getter
@Setter
@SessionScoped
public class TimetableBean implements Serializable{

    @Inject
    private TimetableService timetableService;

    private static final String DEFAULT_STATION = "St.Gallen";

    private String currentStation;

    private List<TimetableDTO> timetableList;

    private List<String> stations;

    @PostConstruct
    public void init(){
        currentStation = DEFAULT_STATION;
        updateTimetable();
        stations = new ArrayList<>();
        for(StationDTO stationDTO : timetableService.getStations()){
            stations.add(stationDTO.getTitle());
        }
    }

    public void updateTimetable(){
        timetableService.updateTimetablesMap();
        timetableList = timetableService.getTimetablesMap().get(currentStation);
    }

}
