package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Market;

public interface MarketRepository extends JpaRepository<Market,Long>{

	@Query("FROM marketcategory WHERE name = ?1")
	List<Market> findAllByName(String name);
	
	@Query("FROM marketcategory WHERE duration = ?1")
	List<Market> findAllByDuration(String duration);
		
	@Query("FROM marketcategory WHERE region = ?1")
	List<Market> findAllByRegion(String region);
	
	@Query("FROM marketcategory WHERE item = ?1")
	List<Market> findAllByItem(String item);
	
	@Query("FROM marketcategory WHERE contact = ?1")
	List<Market> findAllByContact(String contact);
		
	@Query("FROM marketcategory WHERE picture = ?1")
	List<Market> findAllByPicture(String picture);
	
	@Query("FROM marketcategory WHERE price = ?1")
	List<Market> findAllByPrice(String price);

	@Query("FROM marketcategory WHERE description = ?1")
	List<Market> findAllByDescription(String description);
	
}
