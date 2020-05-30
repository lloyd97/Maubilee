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
	
	@GetMapping("/travel/byName/{name}")
	public List<Travel> byName(@PathVariable(value ="name") String name) {
		return this.travelRepository.findAllByName(name);
	}
	
	@GetMapping("/travel/byEnddate/{enddate}")
	public List<Travel> byEnddate(@PathVariable(value ="enddate") String enddate) {
		return this.travelRepository.findAllByEnddate(enddate);
	}
	
	@GetMapping("/travel/byDestination/{destination}")
	public List<Travel> byDestination(@PathVariable(value ="destination") String destination) {
		return this.travelRepository.findAllByDestination(destination);
	}
	
	@GetMapping("/travel/byPackages/{packages}")
	public List<Travel> byPackages(@PathVariable(value ="packages") String packages) {
		return this.travelRepository.findAllByPackages(packages);
	}
	
	@GetMapping("/travel/byContact/{contact}")
	public List<Travel> byContact(@PathVariable(value ="contact") String contact) {
		return this.travelRepository.findAllByContact(contact);
	}
	
	@GetMapping("/travel/byPicture/{picture}")
	public List<Travel> byPicture(@PathVariable(value ="picture") String picture) {
		return this.travelRepository.findAllByPicture(picture);
	}
	
	@GetMapping("/travel/byDescription/{description}")
	public List<Travel> byDescription(@PathVariable(value ="description") String description) {
		return this.travelRepository.findAllByDescription(description);
	}
	
	@GetMapping("/travel/byPrice/{price}")
	public List<Travel> byPrice(@PathVariable(value ="price") String price) {
		return this.travelRepository.findAllByPrice(price);
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
