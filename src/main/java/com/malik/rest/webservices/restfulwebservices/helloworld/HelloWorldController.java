package com.malik.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

//definces this is rest api
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
    //this is how we define a function is get post or delete
    // we can use GetMapping(path="/hello-world") -this is better
    @RequestMapping(method= RequestMethod.GET, path="/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("HEllo World");
    }
    @GetMapping(path="/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("HEllo World, %s",name));
    }
    
    @GetMapping(path="/hello-world-international")
    public String helloWorldBeanInternational(
//    		@RequestHeader(name="accept-language", required=false) Locale locale
    		){
        return messageSource.getMessage("good.morning.message", null,"default message",
//        		locale
        		LocaleContextHolder.getLocale()
        		);
    }
}
