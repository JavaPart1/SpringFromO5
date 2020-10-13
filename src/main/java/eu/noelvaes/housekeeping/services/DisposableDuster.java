package eu.noelvaes.housekeeping.services;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Profile("!bigHouse")
public class DisposableDuster implements CleaningTool{
    private boolean used;

    @Override
    public void doCleanJob() {
        if (used){
            System.out.println("I'm used. Please throw me away");
        }else {
            System.out.println("clean a volonté");
            used = true;
        }

    }
}
