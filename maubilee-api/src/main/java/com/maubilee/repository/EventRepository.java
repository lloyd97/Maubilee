package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Event;


public interface EventRepository extends JpaRepository<Event,Long>{

	@Query("FROM eventcategory WHERE name = ?1")
	List<Event> findAllByName(String name);
	
	@Query("FROM eventcategory WHERE date = ?1")
	List<Event> findAllByDate(String date);
		
	@Query("FROM eventcategory WHERE region = ?1")
	List<Event> findAllByRegion(String region);
	
	@Query("FROM eventcategory WHERE type = ?1")
	List<Event> findAllByType(String type);
	
	@Query("FROM eventcategory WHERE contact = ?1")
	List<Event> findAllByContact(String contact);
		
	@Query("FROM eventcategory WHERE picture = ?1")
	List<Event> findAllByPicture(String picture);

	@Query("FROM eventcategory WHERE description = ?1")
	List<Event> findAllByDescription(String description);
		
	@Query("FROM eventcategory WHERE price = ?1")
	List<Event> findAllByPrice(String price);
	
}
