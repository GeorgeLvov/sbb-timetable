package com.tsystems.javaschool.sbb.ejb;

import com.tsystems.javaschool.sbb.dto.TimetableDTO;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
public class TimetableBean implements Serializable {

    public List<TimetableDTO> timetableList;

    @Produces
    @Named
    public List<TimetableDTO> getTimetableList() {
  /*      TimetableDTO timetableDTO = new TimetableDTO("e200", "Bern", "StGallen",
                new Date(), new Date(), 0, false);
        timetableList = new ArrayList<>();
        timetableList.add(timetableDTO);*/
        return timetableList;
    }

    public void setTimetableList(List<TimetableDTO> timetableList) {
        this.timetableList = timetableList;
    }


}
