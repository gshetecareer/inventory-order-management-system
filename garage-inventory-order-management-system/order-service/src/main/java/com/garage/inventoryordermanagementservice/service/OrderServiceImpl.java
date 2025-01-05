package com.garage.inventoryordermanagementservice.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.garage.inventoryordermanagementservice.dto.PartOrderRequest;
import com.garage.inventoryordermanagementservice.dto.PartOrderResponse;
import com.garage.inventoryordermanagementservice.dto.PartResponse;
import com.garage.inventoryordermanagementservice.entity.Part;
import com.garage.inventoryordermanagementservice.entity.PartOrder;
import com.garage.inventoryordermanagementservice.exception.OrderFailedException;
import com.garage.inventoryordermanagementservice.exception.PartNotFoundException;
import com.garage.inventoryordermanagementservice.exception.PartOrderIdNotFoundException;
import com.garage.inventoryordermanagementservice.helper.PartMapper;
import com.garage.inventoryordermanagementservice.helper.PartOrderMapper;
import com.garage.inventoryordermanagementservice.repository.OrderRepository;
import com.garage.inventoryordermanagementservice.service.interfaces.InventoryPartService;
import com.garage.inventoryordermanagementservice.service.interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private InventoryPartService inventoryService;
    
    @Autowired
    private OrderRepository orderRepository;
    
	/**
	 *
	 */
	@Override
	public PartOrderResponse checkAndPlaceOrder(PartOrderRequest orderRequest) {
		
		ResponseEntity<PartResponse> partOptionalObj = inventoryService.getPartDetailsById(orderRequest.getPartId());
		
		if (partOptionalObj == null) {
			throw new PartNotFoundException(HttpStatus.BAD_REQUEST.value(), "PartNotFoundException", "Part not found");
		}
		PartResponse partResp = partOptionalObj.getBody();
        // Automatic order placement if stock falls below threshold
        if (partResp.getAvailableQuantity() <= partResp.getThresholdLimit()) {
            if (partResp.getIsInternationalSupplier()) {
                LocalTime currentTime = LocalTime.now();
                if (currentTime.isBefore(LocalTime.of(0, 0)) || currentTime.isAfter(LocalTime.of(1, 0))) {
                    throw new OrderFailedException(HttpStatus.BAD_REQUEST.value(), "OrderFailedException", "Order for Supplier-B can only be placed between 12:00 AM and 01:00 AM.");
                }
            }            
            Part partInfo = PartMapper.dtoToEntity(partResp);            		
            // Create Order
            PartOrder order = PartOrder.builder()
            		.part(partInfo)            		
            		.orderQuantity(partResp.getMinimumOrderQuantity())
            		.supplierName(partResp.getSupplierName())
            		.orderTime(LocalDateTime.now())
            		.build();            
            // Save Order
            PartOrder pOrder = orderRepository.save(order);
            PartOrderResponse por = PartOrderMapper.entityToDto(pOrder);
            return por;
        }
        throw new RuntimeException("Stock is sufficient, no need to place an order.");
	}

	/**
	 * Returns a list of all part orders
	 */
	@Override
	public List<PartOrderResponse> fetchAllPartOrders() {
		List<PartOrderResponse> partOrderResp = new ArrayList<PartOrderResponse>();
		orderRepository.findAll().forEach(partOrderObj -> partOrderResp.add(PartOrderMapper.entityToDto(partOrderObj)));
		return partOrderResp;
	}

	@Override
	public PartOrderResponse fetchPartOrderById(Long partOrderId) {
		// TODO Auto-generated method stub
		return PartOrderMapper.entityToDto(this.orderRepository.findById(partOrderId)
				.orElseThrow(() -> new PartOrderIdNotFoundException(HttpStatus.NO_CONTENT.value(),"PartOrderIdNotFoundException", "Not found")));	
	}
}
