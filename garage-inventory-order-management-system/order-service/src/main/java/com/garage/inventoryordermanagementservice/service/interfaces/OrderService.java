package com.garage.inventoryordermanagementservice.service.interfaces;

import java.util.List;

import com.garage.inventoryordermanagementservice.dto.PartOrderRequest;
import com.garage.inventoryordermanagementservice.dto.PartOrderResponse;

public interface OrderService {
	public PartOrderResponse checkAndPlaceOrder(PartOrderRequest orderRequest);
	public List<PartOrderResponse> fetchAllPartOrders();	
	public PartOrderResponse fetchPartOrderById(Long partOrderId);
}
