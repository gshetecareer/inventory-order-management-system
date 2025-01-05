package com.garage.inventorystockmanagementservice.service.interfaces;

import java.util.List;

import com.garage.inventorystockmanagementservice.dto.PartRequest;
import com.garage.inventorystockmanagementservice.dto.PartResponse;
import com.garage.inventorystockmanagementservice.dto.PartStockUpdateRequest;
import com.garage.inventorystockmanagementservice.dto.PartStockUpdateResponse;

public interface PartStockManagementService {
	
	PartResponse addPart(PartRequest part);	 
	PartResponse getPartDetailsById(Long id);
    void deletePartById(Long id);
    PartRequest updatePartById(Long id, PartRequest partDetails);
    List<PartResponse> getAllParts();
    PartStockUpdateResponse updatePartStock(PartStockUpdateRequest stockUpdateRequest);
	 

}
