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
import com.maubilee.model.Travel;
import com.maubilee.repository.TravelRepository;

@RestController
@RequestMapping("/maubilee/")
public class TravelController {

	@Autowired
	private TravelRepository travelRepository;
	
	//get travel
	@GetMapping("travel")
	public List<Travel> getAllTravel(){
		return this.travelRepository.findAll();
	}
	
	//get travel by id
	@GetMapping("/travel/{id}")
	public ResponseEntity<Travel> getTravelById(@PathVariable(value = "id") Long travelId)
		throws ResourceNotFoundException {
		Travel travel = travelRepository.findById(travelId)
					.orElseThrow(() -> new ResourceNotFoundException("Travel not found for this id: "+ travelId));
		return ResponseEntity.ok().body(travel);
	}
	
	//save travel
	@PostMapping("travel")
	public Travel createTravel(@RequestBody Travel travel) {
		return this.travelRepository.saveAndFlush(travel);
	}
		
	//update travel
	@PutMapping("/travel/{id}")
	public ResponseEntity<Travel> updateTravel(@PathVariable(value = "id") Long travelId,
			@Valid @RequestBody Travel travelDetails) throws ResourceNotFoundException {
		Travel travel = travelRepository.findById(travelId)
				.orElseThrow(() -> new ResourceNotFoundException("Travel not found for this id :: " + travelId));
		travel.setName(travelDetails.getName());
		travel.setEndDate(travelDetails.getEndDate());
		travel.setPrice(travelDetails.getPrice());
		travel.setDescription(travelDetails.getDescription());
		travel.setDestination(travelDetails.getDestination());
		travel.setContact(travelDetails.getContact());
		travel.setPicture(travelDetails.getPicture());
		final Travel travelUpdated= travelRepository.save(travel);
		return ResponseEntity.ok(travelUpdated);
	}
		
	//delete travel
	@DeleteMapping("/travel/{id}")
	public Map<String, Boolean> deleteTravel(@PathVariable(value = "id") Long travelId)
			throws ResourceNotFoundException {
		Travel travel  = travelRepository.findById(travelId)
				.orElseThrow(() -> new ResourceNotFoundException("Travel not found for this id :: " + travelId));
		travelRepository.delete(travel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
