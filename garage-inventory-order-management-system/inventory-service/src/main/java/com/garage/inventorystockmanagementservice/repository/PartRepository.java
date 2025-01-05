package com.garage.inventorystockmanagementservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.garage.inventorystockmanagementservice.entity.Part;

public interface PartRepository extends JpaRepository<Part, Long> {
	Optional<Part> findByPartName(String partName);
}
