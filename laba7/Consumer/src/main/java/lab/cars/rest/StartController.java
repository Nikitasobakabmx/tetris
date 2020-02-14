package lab.cars.rest;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/")
public class StartController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView get(){
        ModelAndView mav = new ModelAndView("cars");
        //mav.addObject("cars",  carsService.findAll());
        return mav;
    }
    private String messagesBasename = "/classes/cars";
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setBasenames("file:" + messagesBasename);
        messageSource.setBasename("classpath:cars");
        return messageSource;
    }
}



