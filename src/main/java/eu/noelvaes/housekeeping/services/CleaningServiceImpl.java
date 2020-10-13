package eu.noelvaes.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Profile("smallHouse")
public class CleaningServiceImpl implements CleaningService{
    private CleaningTool cleaningTool;
    private double rate;

    @Autowired
    public void setCleaningTool(CleaningTool cleaningTool) {
        this.cleaningTool = cleaningTool;
    }


    @Value("${rate}")
    public void setRate(double rate) {
        this.rate = rate;
    }

    @PostConstruct
    public void init(){
        System.out.println("Initialising bean CleaningServiceImpl...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("cleaning up bean CleaningServiceImpl..");
    }

    @Override
    public void clean() {
        System.out.println("Cleaning the house");
        cleaningTool.doCleanJob();
    }

    @Override
    public String toString() {
        return "CleaningServiceImpl{" +
                "cleaningTool=" + cleaningTool +
                ", rate=" + rate +
                '}';
    }
}
