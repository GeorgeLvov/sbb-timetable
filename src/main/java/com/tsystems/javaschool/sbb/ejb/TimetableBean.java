package com.tsystems.javaschool.sbb.ejb;

import com.tsystems.javaschool.sbb.dto.TimetableDTO;

import javax.ejb.Singleton;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

@Singleton
public class TimetableBean implements Serializable {

    public List<TimetableDTO> timetableList;

    @Produces
    @Named
    public List<TimetableDTO> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<TimetableDTO> timetableList) {
        this.timetableList = timetableList;
    }


}
