package com.malik.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

//definces this is rest api
@RestController
public class HelloWorldController {
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
}
