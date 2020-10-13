package eu.noelvaes.housekeeping;

import eu.noelvaes.housekeeping.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public CleaningService service(CleaningTool tool){
        CleaningServiceImpl service = new CleaningServiceImpl();
        service.setCleaningTool(tool);
        return service;
    }

}
