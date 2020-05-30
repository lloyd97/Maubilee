package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Event;


public interface EventRepository extends JpaRepository<Event,Long>{

	@Query("FROM Event WHERE name = ?1")
	List<Event> findAllByName(String name);
	
	@Query("FROM Event WHERE date = ?1")
	List<Event> findAllByDate(String date);
		
	@Query("FROM Event WHERE region = ?1")
	List<Event> findAllByRegion(String region);
	
	@Query("FROM Event WHERE type = ?1")
	List<Event> findAllByType(String type);
	
	@Query("FROM Event WHERE contact = ?1")
	List<Event> findAllByContact(String contact);
		
	@Query("FROM Event WHERE picture = ?1")
	List<Event> findAllByPicture(String picture);

	@Query("FROM Event WHERE description = ?1")
	List<Event> findAllByDescription(String description);
		
	@Query("FROM Event WHERE price = ?1")
	List<Event> findAllByPrice(String price);
	
}
