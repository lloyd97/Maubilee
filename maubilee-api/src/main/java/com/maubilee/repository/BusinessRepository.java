package com.maubilee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maubilee.model.Business;

public interface BusinessRepository extends JpaRepository<Business,Long> {

}
