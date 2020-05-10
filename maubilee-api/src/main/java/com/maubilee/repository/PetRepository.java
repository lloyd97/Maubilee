package com.maubilee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maubilee.model.Pet;

public interface PetRepository extends JpaRepository<Pet,Long>{

}
