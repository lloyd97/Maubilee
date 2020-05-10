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
import com.maubilee.model.Land;
import com.maubilee.repository.LandRepository;

@RestController
@RequestMapping("/maubilee/")
public class LandController {

	@Autowired
	private LandRepository landRepository;
	
	//get land
	@GetMapping("land")
	public List<Land> getAllLand(){
		return this.landRepository.findAll();
	}
	
	//get land by id
	@GetMapping("/land/{id}")
	public ResponseEntity<Land> getLandById(@PathVariable(value = "id") Long landId)
		throws ResourceNotFoundException {
		Land land = landRepository.findById(landId)
					.orElseThrow(() -> new ResourceNotFoundException("Land not found for this id: "+ landId));
		return ResponseEntity.ok().body(land);
	}
	
	//save land
	@PostMapping("land")
	public Land createLand(@RequestBody Land land) {
		return this.landRepository.saveAndFlush(land);
	}
		
	//update land
	@PutMapping("/land/{id}")
	public ResponseEntity<Land> updateLand(@PathVariable(value = "id") Long landId,
			@Valid @RequestBody Land landDetails) throws ResourceNotFoundException {
		Land land = landRepository.findById(landId)
				.orElseThrow(() -> new ResourceNotFoundException("Land not found for this id :: " + landId));
		land.setTitle(landDetails.getTitle());
		land.setSurface(landDetails.getSurface());
		land.setRegion(landDetails.getRegion());
		land.setDescription(landDetails.getDescription());
		land.setPrice(landDetails.getPrice());
		land.setContact(landDetails.getContact());
		land.setPicture(landDetails.getPicture());
		final Land landUpdated= landRepository.save(land);
		return ResponseEntity.ok(landUpdated);
	}
		
	//delete land
	@DeleteMapping("/land/{id}")
	public Map<String, Boolean> deleteLand(@PathVariable(value = "id") Long landId)
			throws ResourceNotFoundException {
		Land land  = landRepository.findById(landId)
				.orElseThrow(() -> new ResourceNotFoundException("Land not found for this id :: " + landId));
		landRepository.delete(land);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
