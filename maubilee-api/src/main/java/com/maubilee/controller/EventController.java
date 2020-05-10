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
