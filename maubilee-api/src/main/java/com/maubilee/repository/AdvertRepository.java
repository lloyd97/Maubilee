package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Advert;

public interface AdvertRepository extends JpaRepository<Advert,Long>{

	@Query("FROM maubileeadvert WHERE name = ?1")
	List<Advert> findAllByName(String name);
	
	@Query("FROM maubileeadvert WHERE company = ?1")
	List<Advert> findAllByCompany(String company);
		
	@Query("FROM maubileeadvert WHERE duration = ?1")
	List<Advert> findAllByDuration(String duration);
	
	@Query("FROM maubileeadvert WHERE category = ?1")
	List<Advert> findAllByCategory(String category);
	
	@Query("FROM maubileeadvert WHERE description = ?1")
	List<Advert> findAllByDescription(String description);
		
	@Query("FROM maubileeadvert WHERE price = ?1")
	List<Advert> findAllByPrice(String price);
	
}
