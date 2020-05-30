package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Long>{

	@Query("FROM Vehicle WHERE name = ?1")
	List<Vehicle> findAllByName(String name);
	
	@Query("FROM Vehicle WHERE make = ?1")
	List<Vehicle> findAllByMake(String make);
		
	@Query("FROM Vehicle WHERE type = ?1")
	List<Vehicle> findAllByType(String type);
	
	@Query("FROM Vehicle WHERE transmission = ?1")
	List<Vehicle> findAllByTransmission(String transmission);
	
	@Query("FROM Vehicle WHERE year = ?1")
	List<Vehicle> findAllByYear(String year);
	
	@Query("FROM Vehicle WHERE options = ?1")
	List<Vehicle> findAllByOptions(String options);
	
	@Query("FROM Vehicle WHERE contact = ?1")
	List<Vehicle> findAllByContact(String contact);
		
	@Query("FROM Vehicle WHERE picture = ?1")
	List<Vehicle> findAllByPicture(String picture);
	
	@Query("FROM Vehicle WHERE price = ?1")
	List<Vehicle> findAllByPrice(String price);

	@Query("FROM Vehicle WHERE description = ?1")
	List<Vehicle> findAllByDescription(String description);
	
}
