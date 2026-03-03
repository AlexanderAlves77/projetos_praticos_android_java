package com.fulldevstacks.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fulldevstacks.webservices.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long>
{
	
}
