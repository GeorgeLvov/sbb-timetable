package com.tsystems.javaschool.sbb.service;

import com.tsystems.javaschool.sbb.dto.StationDTO;
import com.tsystems.javaschool.sbb.dto.TimetableDTO;
import com.tsystems.javaschool.sbb.exception.NoStationExistsException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log4j2
@Getter
@Setter
@Singleton
public class TimetableService {

    @EJB
    private RestService restService;

    private Map<String, Integer> stationsMap;

    private Map<String, List<TimetableDTO>> departureTimetablesMap;

    private Map<String, List<TimetableDTO>> arrivalTimetablesMap;


    @PostConstruct
    public void initialize() {
        departureTimetablesMap = new HashMap<>();
        arrivalTimetablesMap = new HashMap<>();
        updateStationsMap();
        getLatestTimetableInfo();

    }

    public void updateStationsMap() {

        stationsMap = restService.getAllStations().stream()
                .collect(Collectors.toMap(StationDTO::getTitle, StationDTO::getId));

        if (!stationsMap.isEmpty()) {
            log.info("Stations were updated!");
        } else {
            log.error("No station exists");
            throw new NoStationExistsException();
        }
    }

    public void getLatestTimetableInfo() {
        for (String stationName : stationsMap.keySet()) {
            departureTimetablesMap.put(stationName,
                    restService.getDepartureTimetableByStationId(stationsMap.get(stationName)));
            arrivalTimetablesMap.put(stationName,
                    restService.getArrivalTimetableByStationId(stationsMap.get(stationName)));
        }
    }

    public List<TimetableDTO> getDepartureTimetableByStation(String stationName) {
        return departureTimetablesMap.get(stationName);
    }

    public List<TimetableDTO> getArrivalTimetableByStation(String stationName) {
        return arrivalTimetablesMap.get(stationName);
    }

}
