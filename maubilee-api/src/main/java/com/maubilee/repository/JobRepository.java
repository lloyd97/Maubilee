package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Job;

public interface JobRepository extends JpaRepository<Job,Long>{

	@Query("FROM Job WHERE title = ?1")
	List<Job> findAllByTitle(String title);
	
	@Query("FROM Job WHERE field = ?1")
	List<Job> findAllByField(String field);
		
	@Query("FROM Job WHERE type = ?1")
	List<Job> findAllByType(String type);
	
	@Query("FROM Job WHERE salary = ?1")
	List<Job> findAllBySalary(String salary);
	
	@Query("FROM Job WHERE region = ?1")
	List<Job> findAllByRegion(String region);
		
	@Query("FROM Job WHERE picture = ?1")
	List<Job> findAllByPicture(String picture);
	
	@Query("FROM Job WHERE contact = ?1")
	List<Job> findAllByContact(String contact);

	@Query("FROM Job WHERE description = ?1")
	List<Job> findAllByDescription(String description);
		
	@Query("FROM Job WHERE company = ?1")
	List<Job> findAllByCompany(String company);
	
}
