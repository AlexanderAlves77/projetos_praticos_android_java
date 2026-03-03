package com.fulldevstacks.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fulldevstacks.webservices.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long>
{
	
}
