package com.garage.inventorystockmanagementservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.inventorystockmanagementservice.dto.PartRequest;
import com.garage.inventorystockmanagementservice.dto.PartResponse;
import com.garage.inventorystockmanagementservice.dto.PartStockUpdateRequest;
import com.garage.inventorystockmanagementservice.dto.PartStockUpdateResponse;
import com.garage.inventorystockmanagementservice.service.interfaces.PartStockManagementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/parts")
public class PartController {
	
    private static final Logger logger = LoggerFactory.getLogger(PartController.class);

    @Autowired
    private PartStockManagementService inventoryService;
    
    @PostMapping("/add")
    public ResponseEntity<PartResponse> addPart(@RequestBody(required = true) PartRequest partRequest) {
    	logger.info("Adding part: {}", partRequest.getPartName());
    	PartResponse savedPartDetails = inventoryService.addPart(partRequest);
    	logger.info("New part added to inventory of id {} and name {}", savedPartDetails.getPartId(),savedPartDetails.getName());
		return ResponseEntity.status(HttpStatus.OK).body(savedPartDetails);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PartRequest> updatePartById(@PathVariable(required = true) Long id, @RequestBody PartRequest partRequest) {
    	logger.info("Updating part with id: {}", id);
    	PartRequest updatedPartDetails = inventoryService.updatePartById(id, partRequest);
    	logger.info("Inventory part details updated of id {} and name {}", updatedPartDetails.getId(),updatedPartDetails.getPartName());
		return ResponseEntity.status(HttpStatus.OK).body(updatedPartDetails);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PartResponse> getPart(@PathVariable(required = true) Long id) {
    	logger.info("Fetching part with id: {}", id);
    	PartResponse partResponse= inventoryService.getPartDetailsById(id);
        return ResponseEntity.status(HttpStatus.OK).body(partResponse);
    }
    
	@GetMapping
	public ResponseEntity<List<PartResponse>> findAllParts() {
		List<PartResponse> partList = inventoryService.getAllParts();
		return ResponseEntity.status(HttpStatus.OK).body(partList);
	}

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePartById(@PathVariable(required = true) Long id){
    	inventoryService.deletePartById(id);
    	return ResponseEntity.status(HttpStatus.OK).body("Part id {} deleted successfuly" + id);
    }
    
    @PutMapping
   	public ResponseEntity<PartStockUpdateResponse> updatePartStock(@RequestBody(required = true) PartStockUpdateRequest stockUpdateRequest) {
       return ResponseEntity.status(HttpStatus.OK).body(inventoryService.updatePartStock(stockUpdateRequest));
     }


}
