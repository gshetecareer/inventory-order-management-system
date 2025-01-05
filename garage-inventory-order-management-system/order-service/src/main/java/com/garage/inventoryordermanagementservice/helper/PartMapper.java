package com.garage.inventoryordermanagementservice.helper;

import com.garage.inventoryordermanagementservice.dto.PartResponse;
import com.garage.inventoryordermanagementservice.entity.Part;

public class PartMapper {

	public static Part dtoToEntity(PartResponse partResponse) {
		Part part = Part.builder()
			.id(partResponse.getPartId())
			.partName(partResponse.getName())
			.description(partResponse.getDescription())
			.categoryType(partResponse.getCategoryType())
			.availableQuantity(partResponse.getAvailableQuantity())
			.supplierName(partResponse.getSupplierName())
			.isInternationalSupplier(partResponse.getIsLocalSupplier())
			.isLocalSupplier(partResponse.getIsInternationalSupplier())
			.minimumOrderQuantity(partResponse.getMinimumOrderQuantity())
			.build();
		return part;
	}
}
