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
import com.maubilee.model.Housing;
import com.maubilee.repository.HousingRepository;

@RestController
@RequestMapping("/maubilee/")
public class HousingController {

	@Autowired
	private HousingRepository housingRepository;
	
	//get housing
	@GetMapping("housing")
	public List<Housing> getAllHousing(){
		return this.housingRepository.findAll();
	}
	
	@GetMapping("/byTitle/{title}")
	public List<Housing> byTitle(@PathVariable(value ="title") String title) {
		return this.housingRepository.findAllByTitle(title);
	}
	
	@GetMapping("/housing/bySurface/{surface}")
	public List<Housing> bySurface(@PathVariable(value ="surface") String surface) {
		return this.housingRepository.findAllBySurface(surface);
	}
	
	@GetMapping("/housing/byRegion/{region}")
	public List<Housing> byRegion(@PathVariable(value ="region") String region) {
		return this.housingRepository.findAllByRegion(region);
	}
	
	@GetMapping("/housing/byBedroom/{bedroom}")
	public List<Housing> byBedroom(@PathVariable(value ="bedroom") String bedroom) {
		return this.housingRepository.findAllByBedroom(bedroom);
	}

	@GetMapping("/housing/byBathroom/{bathroom}")
	public List<Housing> byBathroom(@PathVariable(value ="bathroom") String bathroom) {
		return this.housingRepository.findAllByBathroom(bathroom);
	}
	
	@GetMapping("/byContact/{contact}")
	public List<Housing> byContact(@PathVariable(value ="contact") String contact) {
		return this.housingRepository.findAllByContact(contact);
	}
	
	@GetMapping("/housing/byPicture/{picture}")
	public List<Housing> byPicture(@PathVariable(value ="picture") String picture) {
		return this.housingRepository.findAllByPicture(picture);
	}
	
	@GetMapping("/housing/byDescription/{description}")
	public List<Housing> byDescription(@PathVariable(value ="description") String description) {
		return this.housingRepository.findAllByDescription(description);
	}
	
	@GetMapping("/housing/byPrice/{price}")
	public List<Housing> byPrice(@PathVariable(value ="price") String price) {
		return this.housingRepository.findAllByPrice(price);
	}
	
	
	//get housing by id
	@GetMapping("/housing/{id}")
	public ResponseEntity<Housing> getHousingById(@PathVariable(value = "id") Long housingId)
		throws ResourceNotFoundException {
		Housing housing = housingRepository.findById(housingId)
					.orElseThrow(() -> new ResourceNotFoundException("Housing not found for this id: "+ housingId));
		return ResponseEntity.ok().body(housing);
	}
	
	//save housing
	@PostMapping("housing")
	public Housing createHousing(@RequestBody Housing housing) {
		return this.housingRepository.saveAndFlush(housing);
	}
		
	//update housing
	@PutMapping("/housing/{id}")
	public ResponseEntity<Housing> updateHousing(@PathVariable(value = "id") Long housingId,
			@Valid @RequestBody Housing housingDetails) throws ResourceNotFoundException {
		Housing housing = housingRepository.findById(housingId)
				.orElseThrow(() -> new ResourceNotFoundException("Housing not found for this id :: " + housingId));
		housing.setTitle(housingDetails.getTitle());
		housing.setSurface(housingDetails.getSurface());
		housing.setPrice(housingDetails.getPrice());
		housing.setRegion(housingDetails.getRegion());
		housing.setDescription(housingDetails.getDescription());
		housing.setBedroom(housingDetails.getBedroom());
		housing.setBathroom(housingDetails.getBathroom());
		housing.setContact(housingDetails.getContact());
		housing.setPicture(housingDetails.getPicture());
		final Housing housingUpdated= housingRepository.save(housing);
		return ResponseEntity.ok(housingUpdated);
	}
		
	//delete housing
	@DeleteMapping("/housing/{id}")
	public Map<String, Boolean> deleteHousing(@PathVariable(value = "id") Long housingId)
			throws ResourceNotFoundException {
		Housing housing  = housingRepository.findById(housingId)
				.orElseThrow(() -> new ResourceNotFoundException("Housing not found for this id :: " + housingId));
		housingRepository.delete(housing);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
