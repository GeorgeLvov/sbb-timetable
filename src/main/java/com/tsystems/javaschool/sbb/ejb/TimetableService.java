package com.tsystems.javaschool.sbb.ejb;

import com.tsystems.javaschool.sbb.dto.TimetableDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Arrays;
import java.util.List;

@Stateless
public class TimetableService {

    @EJB
    private TimetableBean timetableBean;

    public void updateTimetable() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/schedule/1");
        List<TimetableDTO> list = Arrays.asList(webTarget.request().get(TimetableDTO[].class));
        timetableBean.setTimetableList(list);
        list.forEach(System.out::println);
        client.close();
    }

}
