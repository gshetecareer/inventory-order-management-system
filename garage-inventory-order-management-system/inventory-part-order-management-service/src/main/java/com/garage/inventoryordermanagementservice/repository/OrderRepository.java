package com.garage.inventoryordermanagementservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.garage.inventoryordermanagementservice.entity.PartOrder;

@Repository	
public interface OrderRepository extends JpaRepository<PartOrder, Long> {
	
}
