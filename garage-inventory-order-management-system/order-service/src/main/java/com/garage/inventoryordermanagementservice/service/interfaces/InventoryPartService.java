package com.garage.inventoryordermanagementservice.service.interfaces;

import org.springframework.http.ResponseEntity;

import com.garage.inventoryordermanagementservice.dto.PartResponse;

public interface InventoryPartService {
	ResponseEntity<PartResponse> getPartDetailsById(Long id);
}
