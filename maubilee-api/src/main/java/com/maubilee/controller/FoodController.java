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
import com.maubilee.model.Food;
import com.maubilee.repository.FoodRepository;



@RestController
@RequestMapping("/maubilee/")
public class FoodController {

	@Autowired
	private FoodRepository foodRepository;
	
	//get user
	@GetMapping("food")
	public List<Food> getAllFood(){
		return this.foodRepository.findAll();
	}
	
	//get user by id
	@GetMapping("/food/{id}")
	public ResponseEntity<Food> getFoodById(@PathVariable(value = "id") Long foodId)
		throws ResourceNotFoundException {
		Food food = foodRepository.findById(foodId)
					.orElseThrow(() -> new ResourceNotFoundException("Food not found for this id: "+ foodId));
		return ResponseEntity.ok().body(food);
	}
	
	//save user
	@PostMapping("food")
	public Food createFood(@RequestBody Food food) {
		return this.foodRepository.saveAndFlush(food);
	}
		
	//update user
		@PutMapping("/food/{id}")
		public ResponseEntity<Food> updateFood(@PathVariable(value = "id") Long foodId,
				@Valid @RequestBody Food foodDetails) throws ResourceNotFoundException {
			Food food = foodRepository.findById(foodId)
					.orElseThrow(() -> new ResourceNotFoundException("Food not found for this id :: " + foodId));

			food.setName(foodDetails.getName());
			food.setEndDate(foodDetails.getEndDate());
			food.setPrice(foodDetails.getPrice());
			food.setRegion(foodDetails.getRegion());
			food.setDescription(foodDetails.getDescription());
			food.setType(foodDetails.getType());
			food.setCategory(foodDetails.getCategory());
			food.setContact(foodDetails.getContact());
			food.setPicture(foodDetails.getPicture());
			final Food foodUpdated= foodRepository.save(food);
			return ResponseEntity.ok(foodUpdated);
		}
		
		//delete user
		@DeleteMapping("/food/{id}")
		public Map<String, Boolean> deleteFood(@PathVariable(value = "id") Long foodId)
				throws ResourceNotFoundException {
			Food food  = foodRepository.findById(foodId)
					.orElseThrow(() -> new ResourceNotFoundException("Food not found for this id :: " + foodId));
			foodRepository.delete(food);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
}
