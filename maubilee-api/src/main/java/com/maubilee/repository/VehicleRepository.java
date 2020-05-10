package com.maubilee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maubilee.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,Long>{

}
