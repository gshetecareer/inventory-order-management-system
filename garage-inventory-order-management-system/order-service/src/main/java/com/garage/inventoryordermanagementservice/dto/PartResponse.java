package com.garage.inventoryordermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.garage.inventoryordermanagementservice.entity.Part;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartResponse {
	
    private Long partId;
    private String name;
    private String description;    
    private Long availableQuantity;
    private Long minimumOrderQuantity;
    private String supplierName;
    private String categoryType;
    private Long thresholdLimit;
    private Boolean isLocalSupplier;    
    private Boolean isInternationalSupplier;
    @Min(1)
    private Double price;
    
    public PartResponse(Part part){
        this.partId = part.getId();
        this.name = part.getPartName();
        this.description = part.getDescription();        
        this.availableQuantity = part.getAvailableQuantity();
        this.minimumOrderQuantity = part.getMinimumOrderQuantity();
        this.supplierName = part.getSupplierName();
        this.categoryType = part.getCategoryType();
        this.thresholdLimit = part.getThresholdLimit();
        this.isInternationalSupplier = part.getIsInternationalSupplier();
        this.isLocalSupplier = part.getIsLocalSupplier();
        this.price = part.getPrice();
    }
}
