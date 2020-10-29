package com.tsystems.javaschool.sbb.ejb;

import com.tsystems.javaschool.sbb.dto.StationDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Stateless
public class TimetableService {

    @EJB
    private TimetableBean timetableBean;

    public void updateTimetable() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/schedule/Bern");
        Object o = webTarget.request().get(StationDTO.class);
        client.close();
    }

}
