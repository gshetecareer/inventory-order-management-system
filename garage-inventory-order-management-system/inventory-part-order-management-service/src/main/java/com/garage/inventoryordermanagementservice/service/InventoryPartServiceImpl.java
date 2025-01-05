package com.garage.inventoryordermanagementservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.garage.inventoryordermanagementservice.dto.PartResponse;
import com.garage.inventoryordermanagementservice.service.interfaces.InventoryPartService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryPartServiceImpl implements InventoryPartService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public ResponseEntity<PartResponse> getPartDetailsById(Long id) {
		// TODO Auto-generated method stub
		ResponseEntity<PartResponse> partResponse= 	restTemplate.
				getForEntity("http://localhost:8081/api/parts/"+id, PartResponse.class);
		log.info("Part Details : ", partResponse.toString());
		return partResponse;
	}

}
