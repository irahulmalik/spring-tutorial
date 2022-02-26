package com.malik.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService userdaoService;

    @GetMapping(path="/users")
    public List<User> retriveAllUsers(){
        return userdaoService.findAll();
    }

    @GetMapping(path="/users/{id}")
    public EntityModel<User> retriveUser(@PathVariable int id){
        User user = userdaoService.findOne(id);
        if(user == null)
        	throw new UserNotFoundException("id -"+id);
        
        EntityModel<User> model = EntityModel.of(user);
        
        WebMvcLinkBuilder linkToUser = linkTo(methodOn(this.getClass()).retriveAllUsers()); 
         model.add(linkToUser.withRel("all-users"));
        
    	return model;
        
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = userdaoService.deleteById(id);
        if(user == null)
        	throw new UserNotFoundException("id -"+id);
    	
        
    }

    //CREATED
    //save all detials of user and return URI
    @PostMapping(path="/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
        User savedUser= userdaoService.save(user);
        URI location = ServletUriComponentsBuilder
        		.fromCurrentRequest()
        		.path("/{id}")
        		.buildAndExpand(savedUser.getId())
        		.toUri();
        
        return ResponseEntity.created(location).build();
    }
}
