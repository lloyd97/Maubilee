package com.maubilee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maubilee.exception.ResourceNotFoundException;
import com.maubilee.model.User;
import com.maubilee.repository.UserRepository;

@RestController
@RequestMapping("/maubilee/")
public class UserController {

	
	//private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	
	//get user
	@GetMapping("user")
	public List<User> getAllUser(){
		return this.userRepository.findAll();
	}
	
	@GetMapping("/byFirstName/{firstname}")
	public List<User> byName(@PathVariable(value ="firstname") String firstname) {
		return this.userRepository.findAllByFirstname(firstname);
	}
	
	@GetMapping("/byLastName/{lastname}")
	public List<User> byLastName(@PathVariable(value ="lastname") String lastname) {
		return this.userRepository.findAllByLastname(lastname);
	}
	
	@GetMapping("/byEmail/{email}")
	public List<User> byEmail(@PathVariable(value ="email") String email) {
		return this.userRepository.findAllByEmail(email);
	}
	
	@GetMapping("/byPassword/{password}")
	public List<User> byPassword(@PathVariable(value ="password") String password) {
		return this.userRepository.findAllByFirstname(password);
	}
	
	@GetMapping("/byRole/{role}")
	public List<User> byRole(@PathVariable(value ="role") String role) {
		return this.userRepository.findAllByFirstname(role);
	}
	
	@GetMapping("/byRegion/{region}")
	public List<User> byRegion(@PathVariable(value ="region") String region) {
		return this.userRepository.findAllByFirstname(region);
	}
	
	@GetMapping("/byCity/{city}")
	public List<User> byCity(@PathVariable(value ="city") String city) {
		return this.userRepository.findAllByFirstname(city);
	}
	
	@GetMapping("/byDob/{dob}")
	public List<User> byDob(@PathVariable(value ="dob") String dob) {
		return this.userRepository.findAllByFirstname(dob);
	}
	
	@GetMapping("/byIsactive/{isactive}")
	public List<User> byIsactive(@PathVariable(value ="isactive") String isactive) {
		return this.userRepository.findAllByFirstname(isactive);
	}
	
	@GetMapping("/byPhone/{phone}")
	public List<User> byPhone(@PathVariable(value ="phone") String phone) {
		return this.userRepository.findAllByFirstname(phone);
	}
	
	@GetMapping("/byRecovercode/{recovercode}")
	public List<User> byRecovercode(@PathVariable(value ="recovercode") String recovercode) {
		return this.userRepository.findAllByFirstname(recovercode);
	}
	
	@GetMapping("/byLocation/{location}")
	public List<User> byLocation(@PathVariable(value ="location") String location) {
		return this.userRepository.findAllByFirstname(location);
	}
	
	@GetMapping("/byPhoto/{photo}")
	public List<User> byPhoto(@PathVariable(value ="photo") String photo) {
		return this.userRepository.findAllByFirstname(photo);
	}
	
	@GetMapping("/byIsdangerous/{isdangerous}")
	public List<User> byIsdangerous(@PathVariable(value ="isdangerous") String isdangerous) {
		return this.userRepository.findAllByFirstname(isdangerous);
	}
	
	@GetMapping("/byPreferences/{preferences}")
	public List<User> byPreferences(@PathVariable(value ="preferences") String preferences) {
		return this.userRepository.findAllByFirstname(preferences);
	}
	
	//get user by id
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
		throws ResourceNotFoundException {
			User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found for this id: "+ userId));
		return ResponseEntity.ok().body(user);
	}
	
	//save user
	@PostMapping("user")
	public User createUser(@RequestBody User user) {
		return this.userRepository.saveAndFlush(user);
	}
		
	//update user
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

		user.setCity(userDetails.getCity());
		user.setDob(userDetails.getDob());
		user.setEmail(userDetails.getEmail());
		user.setRegion(userDetails.getRegion());
		user.setIsactive(userDetails.getIsactive());
		user.setLocation(userDetails.getLocation());
		user.setFirstname(userDetails.getFirstname());
		user.setPassword(userDetails.getPassword());
		user.setPhone(userDetails.getPhone());
		user.setPhoto(userDetails.getPhoto());
		user.setPreferences(userDetails.getPreferences());
		user.setRole(userDetails.getRole());
		user.setLastname(userDetails.getLastname());
		user.setIsdangerous(userDetails.getIsdangerous());
		final User updatedUser= userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	//delete user
	@DeleteMapping("/user/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
			throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	
}
