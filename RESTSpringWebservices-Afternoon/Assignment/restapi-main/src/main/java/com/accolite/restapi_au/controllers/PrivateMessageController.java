package com.accolite.restapi_au.controllers;

import com.accolite.restapi_au.entity.PrivateMessage;
import com.accolite.restapi_au.entity.User;
import com.accolite.restapi_au.service.PrivateMessageService;
import com.accolite.restapi_au.service.UserService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class PrivateMessageController {

    @Autowired
    UserService userService;

    //Create service
    @Autowired
    PrivateMessageService privateMessageService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

  @PostMapping("/add/{userId}")
  public ResponseEntity<Object> postMessage(
      @RequestBody PrivateMessage privateMessage, @PathVariable("userId") Integer userId) {
    User user = userService.getUserById(userId);
    if(user == null) {
        return ResponseEntity.notFound().build();
    }
    privateMessage.setUser(user);
    PrivateMessage createdMessage = privateMessageService.add(privateMessage);
    return new ResponseEntity<Object>(createdMessage, HttpStatus.UNAUTHORIZED);
  }

  @GetMapping("/get/{userId}")
  public ResponseEntity<Object> getMessage(@PathVariable("userId") Integer userId,
                                           @RequestHeader("password") String password) {
    User user = userService.getUserById(userId);

    if (user == null) {
      return ResponseEntity.notFound().build();
    }
    if(bCryptPasswordEncoder.matches(password, user.getPassword())) {
        return ResponseEntity.ok(privateMessageService.getMessages(userId));
    }
      return ResponseEntity.ok("Invalid login");
  }
  
  @PutMapping("/put/{id}")
  public ResponseEntity<Object> putMessage( 
		  @PathVariable Integer id,
		  @RequestBody PrivateMessage privateMessage,
  		@RequestHeader("password") String password){
	  User user = userService.getUserById(id);
	    if(user == null) {
	        return ResponseEntity.notFound().build();
	    }
  	//send it to service
	    if(bCryptPasswordEncoder.matches(password, user.getPassword())) {
	    	privateMessage.setUser(user);
	        PrivateMessage createdMessage = privateMessageService.update(privateMessage,id);
	        return new ResponseEntity<Object>(createdMessage, HttpStatus.UNAUTHORIZED);
	       
	    }
	      return ResponseEntity.ok("Invalid login");

  }
  
  
  @DeleteMapping("/delete/{id}")
  public String deleteMessage(
		  @PathVariable Integer id){
  	return privateMessageService.deleteMessageById(id);
  }
  

  

}
