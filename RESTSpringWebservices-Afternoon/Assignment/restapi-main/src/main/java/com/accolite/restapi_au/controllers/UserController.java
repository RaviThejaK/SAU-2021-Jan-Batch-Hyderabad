package com.accolite.restapi_au.controllers;

import com.accolite.restapi_au.entity.User;
import com.accolite.restapi_au.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public User signUp(@RequestBody Map<String, String> userDetails) {
        System.out.println(userDetails);
        String emailId = userDetails.get("emailId");
        String password = userDetails.get("password");
        User user = new User();
        user.setEmailId(emailId);
        user.setPassword(password);

        //Send it to service
        userService.addUser(user);

        return user;
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }
    
    @PutMapping("/put/{id}")
    public User putUser(@PathVariable Integer id, @RequestBody Map<String, String> userDetails) {
    	System.out.println(userDetails);
        String emailId = userDetails.get("emailId");
        String password = userDetails.get("password");
       // User user = new User();
        User user = userService.getUserById(id);
        
        user.setEmailId(emailId);
        user.setPassword(password);

    	//send it to service
    	userService.update(id,user);
    	return user;
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
    	return userService.deleteUserById(id);
    }
    
    
    

}
