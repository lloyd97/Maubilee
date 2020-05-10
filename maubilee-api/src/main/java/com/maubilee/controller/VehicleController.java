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
