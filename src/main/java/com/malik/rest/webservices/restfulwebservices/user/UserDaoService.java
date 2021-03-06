package com.malik.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private int userCount = 3;
    static {
        users.add(new User(1,"rahul",new Date()));
        users.add(new User(2,"madhur",new Date()));
        users.add(new User(3,"Drake",new Date()));
    }
    //public user getall
    public List<User> findAll(){
        return users;
    }
    //public user sabe
    public User save(User user){
        if(user.getId()==null)
            user.setId(++userCount);

        users.add(user);
        return user;
    }
    //pubic user find one
    public User findOne(int id){
        for (User user:users){
            if (user.getId() == id)
                return user;
        }
        return null;
    }
  //delete user by id
    public User deleteById(int id){
    	Iterator<User> iterator = users.iterator();
    	while (iterator.hasNext()) {
    		User user = iterator.next();
    		if(user.getId() == id) {
    			iterator.remove();
    			return user;
    		}
    	}
        
        
        return null;
    }
    
    
}
