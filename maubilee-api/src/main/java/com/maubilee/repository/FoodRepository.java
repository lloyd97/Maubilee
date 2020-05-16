package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{

	@Query("FROM foodcategory WHERE name = ?1")
	List<Food> findAllByName(String name);
	
	@Query("FROM foodcategory WHERE enddate = ?1")
	List<Food> findAllByEnddate(String enddate);
		
	@Query("FROM foodcategory WHERE region = ?1")
	List<Food> findAllByRegion(String region);
	
	@Query("FROM foodcategory WHERE type = ?1")
	List<Food> findAllByType(String type);
	
	@Query("FROM foodcategory WHERE contact = ?1")
	List<Food> findAllByContact(String contact);
		
	@Query("FROM foodcategory WHERE picture = ?1")
	List<Food> findAllByPicture(String picture);
	
	@Query("FROM foodcategory WHERE category = ?1")
	List<Food> findAllByCategory(String category);

	@Query("FROM foodcategory WHERE description = ?1")
	List<Food> findAllByDescription(String description);
		
	@Query("FROM foodcategory WHERE price = ?1")
	List<Food> findAllByPrice(String price);
	
}
