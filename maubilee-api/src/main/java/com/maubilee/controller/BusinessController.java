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
import com.maubilee.model.Business;
import com.maubilee.repository.BusinessRepository;

@RestController
@RequestMapping("/maubilee/")
public class BusinessController {

	@Autowired
	private BusinessRepository businessRepository;
		
	//get business
	@GetMapping("business")
	public List<Business> getAllBusiness(){
		return this.businessRepository.findAll();
	}
		
	//get business by id
	@GetMapping("/business/{id}")
	public ResponseEntity<Business> getBusinessById(@PathVariable(value = "id") Long businessId)
		throws ResourceNotFoundException {
			Business business = businessRepository.findById(businessId)
					.orElseThrow(() -> new ResourceNotFoundException("Business not found for this id: "+ businessId));
		return ResponseEntity.ok().body(business);
	}
		
	//save business
	@PostMapping("business")
	public Business createBusiness(@RequestBody Business business) {
		return this.businessRepository.saveAndFlush(business);
	}
	
	//update business
	@PutMapping("/business/{id}")
	public ResponseEntity<Business> updateBusiness(@PathVariable(value = "id") Long businessId,
			@Valid @RequestBody Business businessDetails) throws ResourceNotFoundException {
		Business business = businessRepository.findById(businessId)
				.orElseThrow(() -> new ResourceNotFoundException("Business not found for this id :: " + businessId));

		business.setCity(businessDetails.getCity());
		business.setAdvertpicture(businessDetails.getAdvertpicture());
		business.setEmail(businessDetails.getEmail());
		business.setRegion(businessDetails.getRegion());
		business.setIsactive(businessDetails.getIsactive());
		business.setLocation(businessDetails.getLocation());
		business.setName(businessDetails.getName());
		business.setPassword(businessDetails.getPassword());
		business.setPhone(businessDetails.getPhone());
		business.setPhoto(businessDetails.getPhoto());
		business.setAdvertdescription(businessDetails.getAdvertdescription());
		business.setAdvertprice(businessDetails.getAdvertprice());
		business.setAdvertenddate(businessDetails.getAdvertenddate());
		business.setCategory(businessDetails.getCategory());
		business.setPackages(businessDetails.getPackages());
		final Business updatedBusiness= businessRepository.save(business);
		return ResponseEntity.ok(updatedBusiness);
	}
	
	//delete user
	@DeleteMapping("/business/{id}")
	public Map<String, Boolean> deleteBusiness(@PathVariable(value = "id") Long businessId)
			throws ResourceNotFoundException {
		Business business = businessRepository.findById(businessId)
				.orElseThrow(() -> new ResourceNotFoundException("Businesss not found for this id :: " + businessId));
		businessRepository.delete(business);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
			
}
