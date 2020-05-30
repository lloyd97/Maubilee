package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Housing;

public interface HousingRepository extends JpaRepository<Housing,Long> {

	@Query("FROM Housing WHERE title = ?1")
	List<Housing> findAllByTitle(String title);
	
	@Query("FROM Housing WHERE surface = ?1")
	List<Housing> findAllBySurface(String surface);
		
	@Query("FROM Housing WHERE bedroom = ?1")
	List<Housing> findAllByBedroom(String bedroom);
	
	@Query("FROM Housing WHERE bathroom = ?1")
	List<Housing> findAllByBathroom(String bathroom);
	
	@Query("FROM Housing WHERE region = ?1")
	List<Housing> findAllByRegion(String region);
		
	@Query("FROM Housing WHERE picture = ?1")
	List<Housing> findAllByPicture(String picture);
	
	@Query("FROM Housing WHERE contact = ?1")
	List<Housing> findAllByContact(String contact);

	@Query("FROM Housing WHERE description = ?1")
	List<Housing> findAllByDescription(String description);
		
	@Query("FROM Housing WHERE price = ?1")
	List<Housing> findAllByPrice(String price);
	
}
