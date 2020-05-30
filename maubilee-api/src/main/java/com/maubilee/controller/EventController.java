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
import com.maubilee.model.Event;
import com.maubilee.repository.EventRepository;

@RestController
@RequestMapping("/maubilee/")
public class EventController {
	@Autowired
	private EventRepository eventRepository;
	
	//get event
	@GetMapping("event")
	public List<Event> getAllEvent(){
		return this.eventRepository.findAll();
	}
	
	@GetMapping("/event/byName/{name}")
	public List<Event> byName(@PathVariable(value ="name") String name) {
		return this.eventRepository.findAllByName(name);
	}
	
	@GetMapping("/event/byDate/{date}")
	public List<Event> byDate(@PathVariable(value ="date") String date) {
		return this.eventRepository.findAllByDate(date);
	}
	
	@GetMapping("/event/byRegion/{region}")
	public List<Event> byRegion(@PathVariable(value ="region") String region) {
		return this.eventRepository.findAllByRegion(region);
	}
	
	@GetMapping("/event/byType/{type}")
	public List<Event> byType(@PathVariable(value ="type") String type) {
		return this.eventRepository.findAllByType(type);
	}
	
	@GetMapping("/event/byContact/{contact}")
	public List<Event> byContact(@PathVariable(value ="contact") String contact) {
		return this.eventRepository.findAllByContact(contact);
	}
	
	@GetMapping("/event/byPicture/{picture}")
	public List<Event> byPicture(@PathVariable(value ="picture") String picture) {
		return this.eventRepository.findAllByPicture(picture);
	}
	
	@GetMapping("/event/byDescription/{description}")
	public List<Event> byDescription(@PathVariable(value ="description") String description) {
		return this.eventRepository.findAllByDescription(description);
	}
	
	@GetMapping("/event/byPrice/{price}")
	public List<Event> byPrice(@PathVariable(value ="price") String price) {
		return this.eventRepository.findAllByPrice(price);
	}
	
	//get event by id
	@GetMapping("/event/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable(value = "id") Long eventId)
		throws ResourceNotFoundException {
		Event event = eventRepository.findById(eventId)
					.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id: "+ eventId));
		return ResponseEntity.ok().body(event);
	}
	
	//save event
	@PostMapping("event")
	public Event createEvent(@RequestBody Event event) {
		return this.eventRepository.saveAndFlush(event);
	}
		
	//update event
	@PutMapping("/event/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable(value = "id") Long eventId,
			@Valid @RequestBody Event eventDetails) throws ResourceNotFoundException {
		Event event = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
		event.setName(eventDetails.getName());
		event.setDate(eventDetails.getDate());
		event.setPrice(eventDetails.getPrice());
		event.setRegion(eventDetails.getRegion());
		event.setDescription(eventDetails.getDescription());
		event.setType(eventDetails.getType());
		event.setContact(eventDetails.getContact());
		event.setPicture(eventDetails.getPicture());
		final Event eventUpdated= eventRepository.save(event);
		return ResponseEntity.ok(eventUpdated);
	}
		
	//delete event
	@DeleteMapping("/event/{id}")
	public Map<String, Boolean> deleteEvent(@PathVariable(value = "id") Long eventId)
			throws ResourceNotFoundException {
		Event event  = eventRepository.findById(eventId)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found for this id :: " + eventId));
		eventRepository.delete(event);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
