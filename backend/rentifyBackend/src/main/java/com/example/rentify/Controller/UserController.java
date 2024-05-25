package com.example.rentify.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rentify.Entity.UserEntity;
import com.example.rentify.Service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	 @Autowired
	    private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<?> registerUser(@RequestBody UserEntity user) {
	    	if( userService.saveUser(user) != null) {
	    		return ResponseEntity.ok().body("Success!");
	    	}
	    	return ResponseEntity.status(401).body("Email id already registered");
	    }
	    
	    @GetMapping("/getAlluser")
	    public List<UserEntity> getAlluser() {
	        return userService.getAllUser();
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
	        String email = credentials.get("email");
	        String password = credentials.get("password");

	        UserEntity userOpt = userService.findByEmail(email);

	        if (userOpt != null) {
	        	UserEntity user = userOpt;
	            if (user.getPassword().equals(password)) {
	                return ResponseEntity.ok(Map.of("message", "Login successful", "userType", user));
	            } else {
	                return ResponseEntity.status(401).body("Invalid password");
	            }
	        } else {
	            return ResponseEntity.status(404).body("User not found");
	        }
	    }
	    
	    @GetMapping("/getUser/{emailId}")
	    public ResponseEntity<?> getUserByEmail(@PathVariable String emailId) {
	        UserEntity user = userService.findByEmail(emailId);
	        if (user != null) {
	            return ResponseEntity.ok().body(user);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	        }
	    }
}
