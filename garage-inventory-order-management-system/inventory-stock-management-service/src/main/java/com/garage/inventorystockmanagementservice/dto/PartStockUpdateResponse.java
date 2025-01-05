package com.garage.inventorystockmanagementservice.dto;

import com.garage.inventorystockmanagementservice.entity.Part;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartStockUpdateResponse {

	  @NotNull
	  private Long partId;
	  
	  private String partName;

	  @NotNull
	  private Long quantity;
	  
	  public PartStockUpdateResponse(Part part){
	        this.partId = part.getId();
	        this.partName = part.getPartName();
	        this.quantity = part.getAvailableQuantity();
	    }
	  
}
