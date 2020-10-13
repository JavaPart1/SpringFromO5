package eu.noelvaes.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.logging.Logger;

@Component("domesticService")
@Profile("smallHouse | bigHouse")
public class DomesticServiceImpl implements DomesticService{
    @Autowired
    private CleaningService cs;
    @Autowired
    private GardeningService gs;
    @Autowired
    private Logger logger;

//    public void setCs(CleaningService cs) {
//        this.cs = cs;
//    }
//
//    public void setGs(GardeningService gs) {
//        this.gs = gs;
//    }
//
    @PostConstruct
    public void init(){
        System.out.println("Initialising bean DomesticServiceImpl...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Cleaning up bean DomesticServiceImpl..");
    }

    @Override
    public void runHouseHold() {
        logger.info("Running household");
        this.cs.clean();
        System.out.println(this.cs.toString());
        this.gs.garden();

    }
}
