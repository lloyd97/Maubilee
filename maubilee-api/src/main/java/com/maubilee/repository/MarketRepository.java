package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Market;

public interface MarketRepository extends JpaRepository<Market,Long>{

	@Query("FROM Market WHERE name = ?1")
	List<Market> findAllByName(String name);
	
	@Query("FROM Market WHERE duration = ?1")
	List<Market> findAllByDuration(String duration);
		
	@Query("FROM Market WHERE region = ?1")
	List<Market> findAllByRegion(String region);
	
	@Query("FROM Market WHERE item = ?1")
	List<Market> findAllByItem(String item);
	
	@Query("FROM Market WHERE contact = ?1")
	List<Market> findAllByContact(String contact);
		
	@Query("FROM Market WHERE picture = ?1")
	List<Market> findAllByPicture(String picture);
	
	@Query("FROM Market WHERE price = ?1")
	List<Market> findAllByPrice(String price);

	@Query("FROM Market WHERE description = ?1")
	List<Market> findAllByDescription(String description);
	
}
