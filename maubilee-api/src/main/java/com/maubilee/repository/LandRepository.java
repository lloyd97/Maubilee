package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Land;

public interface LandRepository extends JpaRepository<Land,Long>{

	@Query("FROM landcategory WHERE title = ?1")
	List<Land> findAllByTitle(String title);
	
	@Query("FROM landcategory WHERE surface = ?1")
	List<Land> findAllBySurface(String surface);
		
	@Query("FROM landcategory WHERE region = ?1")
	List<Land> findAllByRegion(String region);
		
	@Query("FROM landcategory WHERE picture = ?1")
	List<Land> findAllByPicture(String picture);
	
	@Query("FROM landcategory WHERE contact = ?1")
	List<Land> findAllByContact(String contact);

	@Query("FROM landcategory WHERE description = ?1")
	List<Land> findAllByDescription(String description);
		
	@Query("FROM landcategory WHERE price = ?1")
	List<Land> findAllByPrice(String price);
	
}
