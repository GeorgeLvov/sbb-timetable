package com.tsystems.javaschool.sbb.service;

import com.tsystems.javaschool.sbb.dto.StationDTO;
import com.tsystems.javaschool.sbb.dto.TimetableDTO;

import javax.ejb.Singleton;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Singleton
public class RestService {


    public List<TimetableDTO> getDepartureTimetableByStationId(int stationId) {

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080/timetable/departure/" + stationId);

        List<TimetableDTO> result = Arrays.asList(webTarget.request().get(TimetableDTO[].class));

        client.close();

        return result;
    }

    public List<TimetableDTO> getArrivalTimetableByStationId(int stationId) {

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080/timetable/arrival/" + stationId);

        List<TimetableDTO> result = Arrays.asList(webTarget.request().get(TimetableDTO[].class));

        client.close();

        return result;
    }


    public List<StationDTO> getAllStations(){

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target("http://localhost:8080/stations");

        List<StationDTO> result = new ArrayList<>(Arrays.asList(webTarget.request().get(StationDTO[].class)));

        client.close();

        return result;
    }

}
