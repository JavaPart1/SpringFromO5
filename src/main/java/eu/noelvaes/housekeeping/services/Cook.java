package eu.noelvaes.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Primary
@Profile("smallHouse")
public class Cook {
    @Autowired
    private ApplicationEventPublisher publisher;

    @EventListener
    @Order(2)
    public void makeLunch(ContextStartedEvent e){
        System.out.println("Cook - Context started");
        System.out.println("Cook - Making lunch");
        publisher.publishEvent(new LunchEvent());
    }

}
