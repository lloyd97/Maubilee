package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Pet;

public interface PetRepository extends JpaRepository<Pet,Long>{

	@Query("FROM Pet WHERE name = ?1")
	List<Pet> findAllByName(String name);
	
	@Query("FROM Pet WHERE type = ?1")
	List<Pet>  findAllByType(String type);
		
	@Query("FROM Pet WHERE petshop = ?1")
	List<Pet> findAllByPetshop(String petshop);
	
	@Query("FROM Pet WHERE breed = ?1")
	List<Pet> findAllByBreed(String breed);
	
	@Query("FROM Pet WHERE contact = ?1")
	List<Pet> findAllByContact(String contact);
		
	@Query("FROM Pet WHERE picture = ?1")
	List<Pet> findAllByPicture(String picture);
	
	@Query("FROM Pet WHERE price = ?1")
	List<Pet> findAllByPrice(String price);

	@Query("FROM Pet WHERE description = ?1")
	List<Pet> findAllByDescription(String description);
	
}
