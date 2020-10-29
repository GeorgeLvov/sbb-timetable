package com.tsystems.javaschool.sbb.ejb;

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
        //List response = Arrays.asList(webTarget.request().get(String[].class));
        System.out.println(webTarget.request().get());
        client.close();
    }

}
