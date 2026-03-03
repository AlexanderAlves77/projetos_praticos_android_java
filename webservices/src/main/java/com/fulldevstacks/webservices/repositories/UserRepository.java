package com.fulldevstacks.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fulldevstacks.webservices.entities.User;


public interface UserRepository extends JpaRepository<User, Long>
{
	
}
