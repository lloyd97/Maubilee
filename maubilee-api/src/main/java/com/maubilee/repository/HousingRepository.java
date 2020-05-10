package com.maubilee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maubilee.model.Housing;

public interface HousingRepository extends JpaRepository<Housing,Long> {

}
