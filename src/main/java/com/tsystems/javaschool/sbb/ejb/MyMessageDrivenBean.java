package com.tsystems.javaschool.sbb.ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


@MessageDriven(name = "MyMessageDrivenBean", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:jms/queue/myQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class MyMessageDrivenBean implements MessageListener {

    @EJB
    private TimetableService timetableService;


    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Async message received: " + message.getBody(String.class));
            timetableService.updateTimetable();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

