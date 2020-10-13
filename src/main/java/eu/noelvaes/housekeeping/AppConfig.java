package eu.noelvaes.housekeeping;

import eu.noelvaes.housekeeping.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    @Profile("default")
    public CleaningService service(CleaningTool tool){
        CleaningServiceImpl service = new CleaningServiceImpl();
        service.setCleaningTool(tool);
        return service;
    }

}
