package eu.noelvaes.housekeeping.services;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LoggerFactory {
    @Bean
    @Scope("prototype")
    @Profile("smallHouse | bigHouse")
    public Logger logger(InjectionPoint ip){

        return Logger.getLogger(ip.getClass().getName());
    }
}
