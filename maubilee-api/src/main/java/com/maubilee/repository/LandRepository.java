package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Land;

public interface LandRepository extends JpaRepository<Land,Long>{

	@Query("FROM Land WHERE title = ?1")
	List<Land> findAllByTitle(String title);
	
	@Query("FROM Land WHERE surface = ?1")
	List<Land> findAllBySurface(String surface);
		
	@Query("FROM Land WHERE region = ?1")
	List<Land> findAllByRegion(String region);
		
	@Query("FROM Land WHERE picture = ?1")
	List<Land> findAllByPicture(String picture);
	
	@Query("FROM Land WHERE contact = ?1")
	List<Land> findAllByContact(String contact);

	@Query("FROM Land WHERE description = ?1")
	List<Land> findAllByDescription(String description);
		
	@Query("FROM Land WHERE price = ?1")
	List<Land> findAllByPrice(String price);
	
}
