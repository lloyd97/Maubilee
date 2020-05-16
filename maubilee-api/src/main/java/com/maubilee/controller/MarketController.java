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
import com.maubilee.model.Market;
import com.maubilee.repository.MarketRepository;

@RestController
@RequestMapping("/maubilee/")
public class MarketController {

	@Autowired
	private MarketRepository marketRepository;
	
	//get market
	@GetMapping("market")
	public List<Market> getAllMarket(){
		return this.marketRepository.findAll();
	}
	
	@GetMapping("/byName/{name}")
	public List<Market> byName(@PathVariable(value ="name") String name) {
		return this.marketRepository.findAllByName(name);
	}
	
	@GetMapping("/byDuration/{duration}")
	public List<Market> byDuration(@PathVariable(value ="duration") String duration) {
		return this.marketRepository.findAllByDuration(duration);
	}
	
	@GetMapping("/byRegion/{region}")
	public List<Market> byRegion(@PathVariable(value ="region") String region) {
		return this.marketRepository.findAllByRegion(region);
	}
	
	@GetMapping("/byItem/{item}")
	public List<Market> byItem(@PathVariable(value ="item") String item) {
		return this.marketRepository.findAllByItem(item);
	}
	
	@GetMapping("/byContact/{contact}")
	public List<Market> byContact(@PathVariable(value ="contact") String contact) {
		return this.marketRepository.findAllByContact(contact);
	}
	
	@GetMapping("/byPicture/{picture}")
	public List<Market> byPicture(@PathVariable(value ="picture") String picture) {
		return this.marketRepository.findAllByPicture(picture);
	}
	
	@GetMapping("/byDescription/{description}")
	public List<Market> byDescription(@PathVariable(value ="description") String description) {
		return this.marketRepository.findAllByDescription(description);
	}
	
	@GetMapping("/byPrice/{price}")
	public List<Market> byPrice(@PathVariable(value ="price") String price) {
		return this.marketRepository.findAllByPrice(price);
	}
	
	//get market by id
	@GetMapping("/market/{id}")
	public ResponseEntity<Market> getMarketById(@PathVariable(value = "id") Long marketId)
		throws ResourceNotFoundException {
		Market market = marketRepository.findById(marketId)
					.orElseThrow(() -> new ResourceNotFoundException("Market not found for this id: "+ marketId));
		return ResponseEntity.ok().body(market);
	}
	
	//save market
	@PostMapping("market")
	public Market createMarket(@RequestBody Market market) {
		return this.marketRepository.saveAndFlush(market);
	}
		
	//update market
	@PutMapping("/market/{id}")
	public ResponseEntity<Market> updateMarket(@PathVariable(value = "id") Long marketId,
			@Valid @RequestBody Market marketDetails) throws ResourceNotFoundException {
		Market market = marketRepository.findById(marketId)
				.orElseThrow(() -> new ResourceNotFoundException("Market not found for this id :: " + marketId));
		market.setName(marketDetails.getName());
		market.setDuration(marketDetails.getDuration());
		market.setPrice(marketDetails.getPrice());
		market.setRegion(marketDetails.getRegion());
		market.setDescription(marketDetails.getDescription());
		market.setItem(marketDetails.getItem());
		market.setContact(marketDetails.getContact());
		market.setPicture(marketDetails.getPicture());
		final Market marketUpdated= marketRepository.save(market);
		return ResponseEntity.ok(marketUpdated);
	}
		
	//delete market
	@DeleteMapping("/market/{id}")
	public Map<String, Boolean> deleteMarket(@PathVariable(value = "id") Long marketId)
			throws ResourceNotFoundException {
		Market market  = marketRepository.findById(marketId)
				.orElseThrow(() -> new ResourceNotFoundException("Market not found for this id :: " + marketId));
		marketRepository.delete(market);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
