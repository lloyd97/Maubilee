package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Long>{

	@Query("FROM vehiclecategory WHERE name = ?1")
	List<Vehicle> findAllByName(String name);
	
	@Query("FROM vehiclecategory WHERE make = ?1")
	List<Vehicle> findAllByMake(String make);
		
	@Query("FROM vehiclecategory WHERE type = ?1")
	List<Vehicle> findAllByType(String type);
	
	@Query("FROM vehiclecategory WHERE transmission = ?1")
	List<Vehicle> findAllByTransmission(String transmission);
	
	@Query("FROM vehiclecategory WHERE year = ?1")
	List<Vehicle> findAllByYear(String year);
	
	@Query("FROM vehiclecategory WHERE options = ?1")
	List<Vehicle> findAllByOptions(String options);
	
	@Query("FROM vehiclecategory WHERE contact = ?1")
	List<Vehicle> findAllByContact(String contact);
		
	@Query("FROM vehiclecategory WHERE picture = ?1")
	List<Vehicle> findAllByPicture(String picture);
	
	@Query("FROM vehiclecategory WHERE price = ?1")
	List<Vehicle> findAllByPrice(String price);

	@Query("FROM vehiclecategory WHERE description = ?1")
	List<Vehicle> findAllByDescription(String description);
	
}
