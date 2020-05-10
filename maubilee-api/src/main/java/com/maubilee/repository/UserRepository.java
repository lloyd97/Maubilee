package com.maubilee.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maubilee.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
