package com.garage.inventorystockmanagementservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PartStockUpdateRequest {
	
	 @NotNull
	  private Long partId;

	  @NotNull
	  private Long quantity;

}
