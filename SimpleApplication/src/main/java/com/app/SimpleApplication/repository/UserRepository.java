package com.app.SimpleApplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.SimpleApplication.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByNameAndSurnameAndDob(String name,String surname,String dob);

}
