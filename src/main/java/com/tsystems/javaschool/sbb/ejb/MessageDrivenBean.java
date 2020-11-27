package com.tsystems.javaschool.sbb.ejb;

import lombok.extern.log4j.Log4j2;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.faces.push.Push;
import javax.faces.push.PushContext;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;


@Log4j2
@MessageDriven(name = "MessageDrivenBean", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",
                propertyValue = "java:jms/topic/myTopic"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge")})
public class MessageDrivenBean implements MessageListener {

    @Inject
    @Push(channel = "timetableChannel")
    private PushContext pushContext;

    @Override
    public void onMessage(Message message) {
        log.info("Message received from producer!");
        pushContext.send("message");
    }
}

