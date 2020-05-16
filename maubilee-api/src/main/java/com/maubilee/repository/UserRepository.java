package com.maubilee.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("FROM maubileeuser WHERE firstname = ?1")
	List<User> findAllByFirstname(String firstname);
	
	@Query("FROM maubileeuser WHERE lasttname = ?1")
	List<User> findAllByLastname(String lasttname);
		
	@Query("FROM maubileeuser WHERE city = ?1")
	List<User> findAllByCity(String city);
	
	@Query("FROM maubileeuser WHERE dob = ?1")
	List<User> findAllByDob(String dob);
	
	@Query("FROM maubileeuser WHERE email = ?1")
	List<User> findAllByEmail(String email);
	
	@Query("FROM maubileeuser WHERE isactive = ?1")
	List<User> findAllByIsactive(String isactive);
	
	@Query("FROM maubileeuser WHERE isdangerous = ?1")
	List<User> findAllByIsdangerous(String isdangerous);
	
	@Query("FROM maubileeuser WHERE password = ?1")
	List<User> findAllByPassword(String password);
	
	@Query("FROM maubileeuser WHERE role = ?1")
	List<User> findAllByRole(String role);
	
	@Query("FROM maubileeuser WHERE region = ?1")
	List<User> findAllByRegion(String region);
	
	@Query("FROM maubileeuser WHERE phone = ?1")
	List<User> findAllByPhone(String phone);
	
	@Query("FROM maubileeuser WHERE recovercode = ?1")
	List<User> findAllByRecovercode(String recovercode);
	
	@Query("FROM maubileeuser WHERE location = ?1")
	List<User> findAllByLocation(String location);
	
	@Query("FROM maubileeuser WHERE photo = ?1")
	List<User> findAllByPhoto(String photo);
		
	@Query("FROM maubileeuser WHERE preferences = ?1")
	List<User> findAllByPreferences(String preferences);
	
}
