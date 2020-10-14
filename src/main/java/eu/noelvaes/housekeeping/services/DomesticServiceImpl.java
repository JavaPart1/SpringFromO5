package eu.noelvaes.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Component("domesticService")
@Profile("smallHouse | bigHouse")
public class DomesticServiceImpl implements DomesticService{
    private CleaningService cs;
    private GardeningService gs;
    @Autowired
    private Logger logger;

    @Autowired
    public void setCs(CleaningService cs) {
        this.cs = cs;
    }

    @Autowired
    public void setGs(GardeningService gs) {
        this.gs = gs;
    }

    @PostConstruct
    public void init(){
        System.out.println("Initialising bean DomesticServiceImpl...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Cleaning up bean DomesticServiceImpl..");
    }

    @EventListener
    @Order(1)
    @Override
    public void runHouseHold(ContextStartedEvent e) {
        System.out.println("DomesticService - Context started");
        logger.info("Running household");
        this.cs.clean();
        System.out.println(this.cs.toString());
        this.gs.garden();

    }
}
