package com.garage.inventoryordermanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garage.inventoryordermanagementservice.dto.PartOrderRequest;
import com.garage.inventoryordermanagementservice.dto.PartOrderResponse;
import com.garage.inventoryordermanagementservice.service.interfaces.OrderService;

@RestController
@RequestMapping("/orders")
public class PartOrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<PartOrderResponse> placeOrder(@RequestBody PartOrderRequest orderRequest) {
    	PartOrderResponse orderResponse = orderService.checkAndPlaceOrder(orderRequest);
        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }
    
	@GetMapping
	public ResponseEntity<List<PartOrderResponse>> fetchAllPartOrders() {
		List<PartOrderResponse> partOrderRespList = orderService.fetchAllPartOrders();
		return ResponseEntity.status(HttpStatus.OK).body(partOrderRespList);
	}
	
	
	@GetMapping("/{productOrderId}")
	public ResponseEntity<PartOrderResponse> getProductOrderById(@PathVariable long partOrderId) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.fetchPartOrderById(partOrderId));
	}
}
