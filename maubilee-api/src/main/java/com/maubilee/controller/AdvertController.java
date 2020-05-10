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
import com.maubilee.model.Advert;
import com.maubilee.repository.AdvertRepository;

@RestController
@RequestMapping("/maubilee/")
public class AdvertController {

	@Autowired
	private AdvertRepository advertRepository;
		
	//get advert
	@GetMapping("advert")
	public List<Advert> getAllAdvert(){
			return this.advertRepository.findAll();
	}
	
	//get advert by id
	@GetMapping("/advert/{id}")
	public ResponseEntity<Advert> getAdvertById(@PathVariable(value = "id") Long advertId)
		throws ResourceNotFoundException {
		Advert advert = advertRepository.findById(advertId)
					.orElseThrow(() -> new ResourceNotFoundException("Advert not found for this id: "+ advertId));
		return ResponseEntity.ok().body(advert);
	}
	
	//save advert
	@PostMapping("advert")
	public Advert createAdvert(@RequestBody Advert advert) {
		return this.advertRepository.saveAndFlush(advert);
	}
	
	//update advert
	@PutMapping("/advert/{id}")
	public ResponseEntity<Advert> updateAdvert(@PathVariable(value = "id") Long advertId,
			@Valid @RequestBody Advert advertDetails) throws ResourceNotFoundException {
		Advert advert = advertRepository.findById(advertId)
				.orElseThrow(() -> new ResourceNotFoundException("Business not found for this id :: " + advertId));

		advert.setCompany(advertDetails.getCompany());
		advert.setDuration(advertDetails.getDuration());
		advert.setCategory(advertDetails.getCategory());
		advert.setDescription(advertDetails.getDescription());
		advert.setPrice(advertDetails.getPrice());
		advert.setName(advertDetails.getName());
		final Advert updatedAdvert= advertRepository.save(advert);
		return ResponseEntity.ok(updatedAdvert);
	}
	
	
	//delete advert
	@DeleteMapping("/advert/{id}")
	public Map<String, Boolean> deleteAdvert(@PathVariable(value = "id") Long advertId)
			throws ResourceNotFoundException {
		Advert advert = advertRepository.findById(advertId)
				.orElseThrow(() -> new ResourceNotFoundException("Advert not found for this id :: " + advertId));
		advertRepository.delete(advert);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
