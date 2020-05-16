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
import com.maubilee.model.Pet;
import com.maubilee.repository.PetRepository;

@RestController
@RequestMapping("/maubilee/")
public class PetController {

	@Autowired
	private PetRepository petRepository;
	
	//get pet
	@GetMapping("pet")
	public List<Pet> getAllPet(){
		return this.petRepository.findAll();
	}
	
	@GetMapping("/byName/{name}")
	public List<Pet> byName(@PathVariable(value ="name") String name) {
		return this.petRepository.findAllByName(name);
	}
	
	@GetMapping("/byDuration/{duration}")
	public List<Pet> byDuration(@PathVariable(value ="duration") String duration) {
		return this.petRepository.findAllByType(duration);
	}
	
	@GetMapping("/byPetshop/{petshop}")
	public List<Pet> byPetshop(@PathVariable(value ="petshop") String petshop) {
		return this.petRepository.findAllByPetshop(petshop);
	}
	
	@GetMapping("/byBreed/{breed}")
	public List<Pet> byBreed(@PathVariable(value ="breed") String breed) {
		return this.petRepository.findAllByBreed(breed);
	}
	
	@GetMapping("/byContact/{contact}")
	public List<Pet> byContact(@PathVariable(value ="contact") String contact) {
		return this.petRepository.findAllByContact(contact);
	}
	
	@GetMapping("/byPicture/{picture}")
	public List<Pet> byPicture(@PathVariable(value ="picture") String picture) {
		return this.petRepository.findAllByPicture(picture);
	}
	
	@GetMapping("/byDescription/{description}")
	public List<Pet> byDescription(@PathVariable(value ="description") String description) {
		return this.petRepository.findAllByDescription(description);
	}
	
	@GetMapping("/byPrice/{price}")
	public List<Pet> byPrice(@PathVariable(value ="price") String price) {
		return this.petRepository.findAllByPrice(price);
	}	
	
	//get pet by id
	@GetMapping("/pet/{id}")
	public ResponseEntity<Pet> getPetById(@PathVariable(value = "id") Long petId)
		throws ResourceNotFoundException {
		Pet pet = petRepository.findById(petId)
					.orElseThrow(() -> new ResourceNotFoundException("Pet not found for this id: "+ petId));
		return ResponseEntity.ok().body(pet);
	}
	
	//save pet
	@PostMapping("pet")
	public Pet createPet(@RequestBody Pet pet) {
		return this.petRepository.saveAndFlush(pet);
	}
		
	//update pet
	@PutMapping("/pet/{id}")
	public ResponseEntity<Pet> updatePet(@PathVariable(value = "id") Long petId,
			@Valid @RequestBody Pet petDetails) throws ResourceNotFoundException {
		Pet pet = petRepository.findById(petId)
				.orElseThrow(() -> new ResourceNotFoundException("Pet not found for this id :: " + petId));
		pet.setName(petDetails.getName());
		pet.setType(petDetails.getType());
		pet.setPrice(petDetails.getPrice());
		pet.setPetshop(petDetails.getPetshop());
		pet.setDescription(petDetails.getDescription());
		pet.setBreed(petDetails.getBreed());
		pet.setContact(petDetails.getContact());
		pet.setPicture(petDetails.getPicture());
		final Pet petUpdated= petRepository.save(pet);
		return ResponseEntity.ok(petUpdated);
	}
		
	//delete pet
	@DeleteMapping("/pet/{id}")
	public Map<String, Boolean> deletePet(@PathVariable(value = "id") Long petId)
			throws ResourceNotFoundException {
		Pet pet  = petRepository.findById(petId)
				.orElseThrow(() -> new ResourceNotFoundException("Pet not found for this id :: " + petId));
		petRepository.delete(pet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
