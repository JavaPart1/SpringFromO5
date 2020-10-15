package eu.noelvaes.housekeeping;

import eu.noelvaes.housekeeping.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    @Profile("smallHouse")
    public MessageSource messageSource(){
        ResourceBundleMessageSource ms =
                new ResourceBundleMessageSource();
        ms.setBasename("housekeeping");
        ms.setDefaultEncoding(null);
        return ms;
    }

    @Bean
    @Profile("spEL")
    public CleaningService service(CleaningTool tool){
        CleaningServiceImpl service = new CleaningServiceImpl();
        service.setCleaningTool(tool);
        return service;
    }

}
