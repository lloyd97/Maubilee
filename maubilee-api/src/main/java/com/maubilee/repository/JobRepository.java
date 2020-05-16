package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Job;

public interface JobRepository extends JpaRepository<Job,Long>{

	@Query("FROM jobcategory WHERE title = ?1")
	List<Job> findAllByTitle(String title);
	
	@Query("FROM jobcategory WHERE field = ?1")
	List<Job> findAllByField(String field);
		
	@Query("FROM jobcategory WHERE type = ?1")
	List<Job> findAllByType(String type);
	
	@Query("FROM jobcategory WHERE salary = ?1")
	List<Job> findAllBySalary(String salary);
	
	@Query("FROM jobcategory WHERE region = ?1")
	List<Job> findAllByRegion(String region);
		
	@Query("FROM jobcategory WHERE picture = ?1")
	List<Job> findAllByPicture(String picture);
	
	@Query("FROM jobcategory WHERE contact = ?1")
	List<Job> findAllByContact(String contact);

	@Query("FROM jobcategory WHERE description = ?1")
	List<Job> findAllByDescription(String description);
		
	@Query("FROM jobcategory WHERE company = ?1")
	List<Job> findAllByCompany(String company);
	
}
