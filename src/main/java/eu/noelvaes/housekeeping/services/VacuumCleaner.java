package eu.noelvaes.housekeeping.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("smallHouse")
@Primary
public class VacuumCleaner implements CleaningTool{
    public void doCleanJob() {
        System.out.println("Zuuuuuuuuuuuuuuuuu");
    }
}
