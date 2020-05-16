package com.maubilee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maubilee.model.Leisure;
public interface LeisureRepository extends JpaRepository<Leisure,Long>{

	@Query("FROM leisurecategory WHERE name = ?1")
	List<Leisure> findAllByName(String name);
	
	@Query("FROM leisurecategory WHERE duration = ?1")
	List<Leisure> findAllByDuration(String duration);
		
	@Query("FROM leisurecategory WHERE packages = ?1")
	List<Leisure> findAllByPackages(String packages);
	
	@Query("FROM leisurecategory WHERE item = ?1")
	List<Leisure> findAllByItem(String item);
	
	@Query("FROM leisurecategory WHERE contact = ?1")
	List<Leisure> findAllByContact(String contact);
		
	@Query("FROM leisurecategory WHERE picture = ?1")
	List<Leisure> findAllByPicture(String picture);
	
	@Query("FROM leisurecategory WHERE category = ?1")
	List<Leisure> findAllByCategory(String category);

	@Query("FROM leisurecategory WHERE description = ?1")
	List<Leisure> findAllByDescription(String description);
		
}
