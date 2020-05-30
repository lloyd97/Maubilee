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
	
	@GetMapping("/food/byName/{name}")
	public List<Food> byName(@PathVariable(value ="name") String name) {
		return this.foodRepository.findAllByName(name);
	}
	
	@GetMapping("/food/byEnddate/{enddate}")
	public List<Food> byDate(@PathVariable(value ="enddate") String enddate) {
		return this.foodRepository.findAllByEnddate(enddate);
	}
	
	@GetMapping("/food/byRegion/{region}")
	public List<Food> byRegion(@PathVariable(value ="region") String region) {
		return this.foodRepository.findAllByRegion(region);
	}
	
	@GetMapping("/food/byType/{type}")
	public List<Food> byType(@PathVariable(value ="type") String type) {
		return this.foodRepository.findAllByType(type);
	}
	
	@GetMapping("/food/byContact/{contact}")
	public List<Food> byContact(@PathVariable(value ="contact") String contact) {
		return this.foodRepository.findAllByContact(contact);
	}
	
	@GetMapping("/food/byPicture/{picture}")
	public List<Food> byPicture(@PathVariable(value ="picture") String picture) {
		return this.foodRepository.findAllByPicture(picture);
	}
	
	@GetMapping("/food/byDescription/{description}")
	public List<Food> byDescription(@PathVariable(value ="description") String description) {
		return this.foodRepository.findAllByDescription(description);
	}
	
	@GetMapping("/food/byPrice/{price}")
	public List<Food> byPrice(@PathVariable(value ="price") String price) {
		return this.foodRepository.findAllByPrice(price);
	}
	
	@GetMapping("/food/byCategory/{category}")
	public List<Food> byCategory(@PathVariable(value ="category") String category) {
		return this.foodRepository.findAllByCategory(category);
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
