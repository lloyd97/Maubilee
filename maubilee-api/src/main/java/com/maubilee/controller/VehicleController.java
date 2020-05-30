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
import com.maubilee.model.Vehicle;
import com.maubilee.repository.VehicleRepository;
//need to add uri for angular
@RestController
@RequestMapping("/maubilee/") 
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	//get vehicle
	@GetMapping("vehicle")
	public List<Vehicle> getAllVehicle(){
		return this.vehicleRepository.findAll();
	}
	
	@GetMapping("/vehicle/byName/{name}")
	public List<Vehicle> byName(@PathVariable(value ="name") String name) {
		return this.vehicleRepository.findAllByName(name);
	}
	
	@GetMapping("/vehicle/byMake/{make}")
	public List<Vehicle> byMake(@PathVariable(value ="make") String make) {
		return this.vehicleRepository.findAllByMake(make);
	}
	
	@GetMapping("/vehicle/byType/{type}")
	public List<Vehicle> byType(@PathVariable(value ="type") String type) {
		return this.vehicleRepository.findAllByType(type);
	}
	
	@GetMapping("/vehicle/byTransmission/{transmission}")
	public List<Vehicle> byTransmission(@PathVariable(value ="transmission") String transmission) {
		return this.vehicleRepository.findAllByTransmission(transmission);
	}
	
	@GetMapping("/vehicle/byContact/{contact}")
	public List<Vehicle> byContact(@PathVariable(value ="contact") String contact) {
		return this.vehicleRepository.findAllByContact(contact);
	}

	@GetMapping("/vehicle/byYear/{year}")
	public List<Vehicle> byYear(@PathVariable(value ="year") String year) {
		return this.vehicleRepository.findAllByYear(year);
	}
	
	@GetMapping("/vehicle/byOptions/{contact}")
	public List<Vehicle> byOptions(@PathVariable(value ="options") String options) {
		return this.vehicleRepository.findAllByOptions(options);
	}
	
	@GetMapping("/vehicle/byPicture/{picture}")
	public List<Vehicle> byPicture(@PathVariable(value ="picture") String picture) {
		return this.vehicleRepository.findAllByPicture(picture);
	}
	
	@GetMapping("/vehicle/byDescription/{description}")
	public List<Vehicle> byDescription(@PathVariable(value ="description") String description) {
		return this.vehicleRepository.findAllByDescription(description);
	}
	
	@GetMapping("/vehicle/byPrice/{price}")
	public List<Vehicle> byPrice(@PathVariable(value ="price") String price) {
		return this.vehicleRepository.findAllByPrice(price);
	}
	
	//get vehicle by id
	@GetMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Long vehicleId)
		throws ResourceNotFoundException {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
					.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id: "+ vehicleId));
		return ResponseEntity.ok().body(vehicle);
	}
	
	//save vehicle
	@PostMapping("vehicle")
	public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
		return this.vehicleRepository.saveAndFlush(vehicle);
	}
		
	//update vehicle
	@PutMapping("/vehicle/{id}")
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable(value = "id") Long vehicleId,
			@Valid @RequestBody Vehicle vehicleDetails) throws ResourceNotFoundException {
		Vehicle vehicle = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));
		vehicle.setName(vehicleDetails.getName());
		vehicle.setMake(vehicleDetails.getMake());
		vehicle.setPrice(vehicleDetails.getPrice());
		vehicle.setTransmission(vehicleDetails.getTransmission());
		vehicle.setYear(vehicleDetails.getYear());
		vehicle.setDescription(vehicleDetails.getDescription());
		vehicle.setType(vehicleDetails.getType());
		vehicle.setContact(vehicleDetails.getContact());
		vehicle.setPicture(vehicleDetails.getPicture());
		final Vehicle vehicleUpdated= vehicleRepository.save(vehicle);
		return ResponseEntity.ok(vehicleUpdated);
	}
		
	//delete vehicle
	@DeleteMapping("/vehicle/{id}")
	public Map<String, Boolean> deleteVehicle(@PathVariable(value = "id") Long vehicleId)
			throws ResourceNotFoundException {
		Vehicle vehicle  = vehicleRepository.findById(vehicleId)
				.orElseThrow(() -> new ResourceNotFoundException("Vehicle not found for this id :: " + vehicleId));
		vehicleRepository.delete(vehicle);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
