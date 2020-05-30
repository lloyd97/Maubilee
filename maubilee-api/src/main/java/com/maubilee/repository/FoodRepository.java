package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{

	@Query("FROM Food WHERE name = ?1")
	List<Food> findAllByName(String name);
	
	@Query("FROM Food WHERE enddate = ?1")
	List<Food> findAllByEnddate(String enddate);
		
	@Query("FROM Food WHERE region = ?1")
	List<Food> findAllByRegion(String region);
	
	@Query("FROM Food WHERE type = ?1")
	List<Food> findAllByType(String type);
	
	@Query("FROM Food WHERE contact = ?1")
	List<Food> findAllByContact(String contact);
		
	@Query("FROM Food WHERE picture = ?1")
	List<Food> findAllByPicture(String picture);
	
	@Query("FROM Food WHERE category = ?1")
	List<Food> findAllByCategory(String category);

	@Query("FROM Food WHERE description = ?1")
	List<Food> findAllByDescription(String description);
		
	@Query("FROM Food WHERE price = ?1")
	List<Food> findAllByPrice(String price);
	
}
