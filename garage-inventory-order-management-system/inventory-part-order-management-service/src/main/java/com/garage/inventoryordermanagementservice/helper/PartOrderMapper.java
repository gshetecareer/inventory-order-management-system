package com.garage.inventoryordermanagementservice.helper;

import com.garage.inventoryordermanagementservice.dto.PartOrderResponse;
import com.garage.inventoryordermanagementservice.entity.PartOrder;

public class PartOrderMapper {
	
	public static PartOrderResponse entityToDto(PartOrder partOrder) {
		
        PartOrderResponse por = PartOrderResponse.builder()
        		.id(partOrder.getId())
        		.orderQuantity(partOrder.getOrderQuantity())
        		.orderStatus(partOrder.getOrderStatus())
        		.orderTime(partOrder.getOrderTime())
        		.supplierName(partOrder.getSupplierName())
        		.part(partOrder.getPart()).build();
        return por;
	}

}
