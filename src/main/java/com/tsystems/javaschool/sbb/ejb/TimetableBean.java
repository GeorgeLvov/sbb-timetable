package com.tsystems.javaschool.sbb.ejb;

import com.tsystems.javaschool.sbb.dto.ScheduleDTO;
import com.tsystems.javaschool.sbb.dto.StationDTO;
import com.tsystems.javaschool.sbb.dto.TrainDTO;
import com.tsystems.javaschool.sbb.dto.TripDTO;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TimetableBean implements Serializable {

    public List<ScheduleDTO> schedulesList;


    public void setSchedulesList(List<ScheduleDTO> schedulesList) {
        this.schedulesList = schedulesList;
    }

    @Produces
    @Named
    public List<ScheduleDTO> getSchedulesList() {
        TrainDTO trainDTO = new TrainDTO(1, "e200", 15);
        StationDTO stationFrom = new StationDTO(1,"SPB");
        StationDTO stationTo = new StationDTO(2,"Moscow");
        Timestamp deptTime = Timestamp.valueOf(LocalDateTime.now());
        Timestamp arrTime = Timestamp.valueOf(LocalDateTime.now().plusMinutes(20));
        ScheduleDTO scheduleDTO =
                new ScheduleDTO(trainDTO, new TripDTO(), stationFrom, stationTo, deptTime, arrTime, 5, false);
        schedulesList = new ArrayList<>();
        schedulesList.add(scheduleDTO);
        return schedulesList;
    }


}
