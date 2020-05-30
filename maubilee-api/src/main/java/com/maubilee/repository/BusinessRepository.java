package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Business;

public interface BusinessRepository extends JpaRepository<Business,Long> {

	/*@Query("FROM maubileebusiness WHERE name = ?1")
	List<Business> findAllByName(String name);
			
	@Query("FROM maubileebusiness WHERE city = ?1")
	List<Business> findAllByCity(String city);
	
	@Query("FROM maubileebusiness WHERE email = ?1")
	List<Business> findAllByEmail(String email);
	
	@Query("FROM maubileebusiness WHERE isactive = ?1")
	List<Business> findAllByIsactive(String isactive);
	
	@Query("FROM maubileebusiness WHERE password = ?1")
	List<Business> findAllByPassword(String password);
	
	@Query("FROM maubileebusiness WHERE role = ?1")
	List<Business> findAllByRole(String role);
	
	@Query("FROM maubileebusiness WHERE region = ?1")
	List<Business> findAllByRegion(String region);
	
	@Query("FROM maubileebusiness WHERE phone = ?1")
	List<Business> findAllByPhone(String phone);
	
	@Query("FROM maubileebusiness WHERE recovercode = ?1")
	List<Business> findAllByRecovercode(String recovercode);
	
	@Query("FROM maubileebusiness WHERE location = ?1")
	List<Business> findAllByLocation(String location);
	
	@Query("FROM maubileebusiness WHERE photo = ?1")
	List<Business> findAllByPhoto(String photo);
		
	@Query("FROM maubileebusiness WHERE advertpicture = ?1")
	List<Business> findAllByAdvertpicture(String advertpicture);
	
	@Query("FROM maubileebusiness WHERE advertdescription = ?1")
	List<Business> findAllByAdvertdescription(String advertdescription);
	
	@Query("FROM maubileebusiness WHERE advertprice = ?1")
	List<Business> findAllByAdvertprice(String advertprice);
	
	@Query("FROM maubileebusiness WHERE advertenddate = ?1")
	List<Business> findAllByAdvertenddate(String advertenddate);
	
	@Query("FROM maubileebusiness WHERE category = ?1")
	List<Business> findAllByCategory(String category);
		
	@Query("FROM maubileebusiness WHERE packages = ?1")
	List<Business> findAllByPackages(String packages);
	*/
	
	
}
