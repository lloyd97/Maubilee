package com.maubilee.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	/*@Query("FROM Account WHERE firstname = ?1")
	List<User> findAllByFirstname(String firstname);
	
	@Query("FROM Account WHERE lasttname = ?1")
	List<User> findAllByLastname(String lasttname);
		
	@Query("FROM Account WHERE city = ?1")
	List<User> findAllByCity(String city);
	
	@Query("FROM Account WHERE dob = ?1")
	List<User> findAllByDob(String dob);
	
	@Query("FROM Account WHERE email = ?1")
	List<User> findAllByEmail(String email);
	
	@Query("FROM Account WHERE isactive = ?1")
	List<User> findAllByIsactive(String isactive);
	
	@Query("FROM Account WHERE isdangerous = ?1")
	List<User> findAllByIsdangerous(String isdangerous);
	
	@Query("FROM Account WHERE password = ?1")
	List<User> findAllByPassword(String password);
	
	@Query("FROM Account WHERE role = ?1")
	List<User> findAllByRole(String role);
	
	@Query("FROM Account WHERE region = ?1")
	List<User> findAllByRegion(String region);
	
	@Query("FROM Account WHERE phone = ?1")
	List<User> findAllByPhone(String phone);
	
	@Query("FROM Account WHERE recovercode = ?1")
	List<User> findAllByRecovercode(String recovercode);
	
	@Query("FROM Account WHERE location = ?1")
	List<User> findAllByLocation(String location);
	
	@Query("FROM Account WHERE photo = ?1")
	List<User> findAllByPhoto(String photo);
		
	@Query("FROM Account WHERE preferences = ?1")
	List<User> findAllByPreferences(String preferences);*/
	
}
