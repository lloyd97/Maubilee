package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Housing;

public interface HousingRepository extends JpaRepository<Housing,Long> {

	@Query("FROM housingcategory WHERE title = ?1")
	List<Housing> findAllByTitle(String title);
	
	@Query("FROM housingcategory WHERE surface = ?1")
	List<Housing> findAllBySurface(String surface);
		
	@Query("FROM housingcategory WHERE bedroom = ?1")
	List<Housing> findAllByBedroom(String bedroom);
	
	@Query("FROM housingcategory WHERE bathroom = ?1")
	List<Housing> findAllByBathroom(String bathroom);
	
	@Query("FROM housingcategory WHERE region = ?1")
	List<Housing> findAllByRegion(String region);
		
	@Query("FROM housingcategory WHERE picture = ?1")
	List<Housing> findAllByPicture(String picture);
	
	@Query("FROM housingcategory WHERE contact = ?1")
	List<Housing> findAllByContact(String contact);

	@Query("FROM housingcategory WHERE description = ?1")
	List<Housing> findAllByDescription(String description);
		
	@Query("FROM housingcategory WHERE price = ?1")
	List<Housing> findAllByPrice(String price);
	
}
