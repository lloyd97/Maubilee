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
import com.maubilee.model.Leisure;
import com.maubilee.repository.LeisureRepository;

@RestController
@RequestMapping("/maubilee/")
public class LeisureController {

	@Autowired
	private LeisureRepository leisureRepository;
	
	//get leisure
	@GetMapping("leisure")
	public List<Leisure> getAllLeisure(){
		return this.leisureRepository.findAll();
	}
	
	//get leisure by id
	@GetMapping("/leisure/{id}")
	public ResponseEntity<Leisure> getLeisureById(@PathVariable(value = "id") Long leisureId)
		throws ResourceNotFoundException {
		Leisure leisure = leisureRepository.findById(leisureId)
					.orElseThrow(() -> new ResourceNotFoundException("Leisure not found for this id: "+ leisureId));
		return ResponseEntity.ok().body(leisure);
	}
	
	//save leisure
	@PostMapping("leisure")
	public Leisure createLeisure(@RequestBody Leisure leisure) {
		return this.leisureRepository.saveAndFlush(leisure);
	}
		
	//update leisure
	@PutMapping("/leisure/{id}")
	public ResponseEntity<Leisure> updateLeisure(@PathVariable(value = "id") Long leisureId,
			@Valid @RequestBody Leisure leisureDetails) throws ResourceNotFoundException {
		Leisure leisure = leisureRepository.findById(leisureId)
				.orElseThrow(() -> new ResourceNotFoundException("Leisure not found for this id :: " + leisureId));
		leisure.setName(leisureDetails.getName());
		leisure.setDuration(leisureDetails.getDuration());
		leisure.setPrice(leisureDetails.getPrice());
		leisure.setPackages(leisureDetails.getPackages());
		leisure.setDescription(leisureDetails.getDescription());
		leisure.setItem(leisureDetails.getItem());
		leisure.setContact(leisureDetails.getContact());
		leisure.setPicture(leisureDetails.getPicture());
		final Leisure leisureUpdated= leisureRepository.save(leisure);
		return ResponseEntity.ok(leisureUpdated);
	}
		
	//delete leisure
	@DeleteMapping("/leisure/{id}")
	public Map<String, Boolean> deleteLeisure(@PathVariable(value = "id") Long leisureId)
			throws ResourceNotFoundException {
		Leisure leisure  = leisureRepository.findById(leisureId)
				.orElseThrow(() -> new ResourceNotFoundException("Leisure not found for this id :: " + leisureId));
		leisureRepository.delete(leisure);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
