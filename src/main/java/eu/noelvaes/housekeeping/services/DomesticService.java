package eu.noelvaes.housekeeping.services;

import org.springframework.context.event.ContextStartedEvent;

public interface DomesticService {
    public void runHouseHold(ContextStartedEvent e);
}
