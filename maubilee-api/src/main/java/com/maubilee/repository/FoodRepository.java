package com.maubilee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maubilee.model.Food;

public interface FoodRepository extends JpaRepository<Food,Long>{

}
