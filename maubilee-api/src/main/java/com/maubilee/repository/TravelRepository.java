package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Travel;

public interface TravelRepository extends JpaRepository<Travel,Long>{

	@Query("FROM travelcategory WHERE name = ?1")
	List<Travel> findAllByName(String name);
	
	@Query("FROM travelcategory WHERE enddate = ?1")
	List<Travel> findAllByEnddate(String enddate);
		
	@Query("FROM travelcategory WHERE destination = ?1")
	List<Travel> findAllByDestination(String destination);
	
	@Query("FROM travelcategory WHERE packages = ?1")
	List<Travel> findAllByPackages(String packages);
	
	@Query("FROM travelcategory WHERE contact = ?1")
	List<Travel> findAllByContact(String contact);
		
	@Query("FROM travelcategory WHERE picture = ?1")
	List<Travel> findAllByPicture(String picture);
	
	@Query("FROM travelcategory WHERE price = ?1")
	List<Travel> findAllByPrice(String price);

	@Query("FROM travelcategory WHERE description = ?1")
	List<Travel> findAllByDescription(String description);
	
}
