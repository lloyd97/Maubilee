package com.maubilee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maubilee.model.Event;


public interface EventRepository extends JpaRepository<Event,Long>{

}
