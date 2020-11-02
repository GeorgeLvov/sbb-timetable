package com.tsystems.javaschool.sbb.service;


import com.tsystems.javaschool.sbb.dto.StationDTO;
import com.tsystems.javaschool.sbb.dto.TimetableDTO;
import com.tsystems.javaschool.sbb.ejb.TimetableBean;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@Singleton
public class TimetableService implements Serializable {

    @EJB
    private RestService restService;

    @Inject
    private TimetableBean timetableBean;

    @Inject
    @Push(channel = "timetableChannel")
    private PushContext pushContext;

    private List<StationDTO> stations;

    private Map<String, List<TimetableDTO>> timetablesMap;


    @PostConstruct
    public void initialize() {
        timetablesMap = new HashMap<>();
        updateTimetablesMap();
    }

    public void updateTimetablesMap() {
        stations = restService.getAllStations();
        for (StationDTO station : stations) {
            timetablesMap.put(station.getTitle(), restService.getTimeTableByStationId(station.getId()));
        }
    }

    public void updateContent(){
        updateTimetablesMap();
        timetableBean.setTimetableList(new ArrayList<>());
        pushContext.send("Timetables updated!");
    }

}

