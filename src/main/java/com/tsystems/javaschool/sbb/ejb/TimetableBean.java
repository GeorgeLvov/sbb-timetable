package com.tsystems.javaschool.sbb.ejb;

import com.tsystems.javaschool.sbb.dto.TimetableDTO;
import com.tsystems.javaschool.sbb.service.TimetableService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Data
@Named
@SessionScoped
public class TimetableBean implements Serializable {

    @EJB
    private TimetableService timetableService;

    private List<String> stations;

    private String currentStation;

    private List<TimetableDTO> departureTimetableList;

    private List<TimetableDTO> arrivalTimetableList;


    @PostConstruct
    public void init() {

        currentStation = timetableService.getStationsMap()
                .keySet().stream().findFirst().get();

        stations = timetableService.getStationsMap().keySet().stream()
                .sorted().collect(Collectors.toList());

        updateTimetableLists();
    }

    public void changeCurrentStation() {
        updateTimetableLists();
    }

    public void updateCurrentTimetable() {
        timetableService.getLatestTimetableInfo();
        updateTimetableLists();
    }

    public void updateTimetableLists() {
        departureTimetableList = timetableService.getDepartureTimetableByStation(currentStation);
        arrivalTimetableList = timetableService.getArrivalTimetableByStation(currentStation);
        log.info("Timetable was updated!");
    }

}
