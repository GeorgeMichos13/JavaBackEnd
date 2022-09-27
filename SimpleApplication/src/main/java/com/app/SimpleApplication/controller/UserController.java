package com.app.SimpleApplication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.SimpleApplication.exception.ResourceNotFoundException;
import com.app.SimpleApplication.model.User;
import com.app.SimpleApplication.repository.UserRepository;

@RestController
//URL END POINT
@RequestMapping("/api/v1/")
@CrossOrigin
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	
	//create user api
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		if(userRepository.findByNameAndSurnameAndDob(user.getName(), user.getSurname(), user.getDob()) != null) {
			return ResponseEntity.status(409).body(user);
		}
		userRepository.save(user);
		return ResponseEntity.ok(user);
	}
	
	
	//get user  id api
	@GetMapping("/users/{id}")
	public ResponseEntity<User>  getUserId(@PathVariable Long id) {
		
		User user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User not found with id:" + id));
		
		return ResponseEntity.ok(user);
	}
	
	//delete user api
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		User user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User not found with id:" + id));
		
		userRepository.delete(user);
		
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted",Boolean.TRUE);
		
		
		return  ResponseEntity.ok(response);
		
	}
}
