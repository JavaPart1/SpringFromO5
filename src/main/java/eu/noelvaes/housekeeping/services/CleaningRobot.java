package eu.noelvaes.housekeeping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

@Component
@Profile("bigHouse")
public class CleaningRobot implements CleaningService{
    private List<CleaningTool> tools;

    @Autowired
    public void setTools(List<CleaningTool> tools) {
        this.tools = tools;
    }

    @PostConstruct
    public void init(){
        System.out.println("Initialising bean CleaningRobot...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Cleaning up bean CleaningRobot..");
    }

    @Override
    public void clean() {
        System.out.println("CCCleaning...");
        tools.forEach(t -> t.doCleanJob());
    }
}
