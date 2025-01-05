package com.garage.inventorystockmanagementservice.dto;

import org.springframework.validation.annotation.Validated;

import com.garage.inventorystockmanagementservice.entity.Part;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.DefaultValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Validated
public class PartRequest {

	private Long id;
	
	@NotBlank(message = "Part's name should not be blank.")
    private String partName;
	
	@NotBlank(message = "Part's description should not be blank.")
    private String description;
	
	@NotBlank(message = "Part's supplier name should not be blank.")
    private String supplierName;
	
	@NotBlank(message = "Part's category type should not be blank.")
	@DefaultValue(value = "two-wheeler")
    private String categoryType;
	
	@NotBlank(message = "Part's threshold Limit should not be blank.")
    private Long thresholdLimit;
	
    @DefaultValue(value = "100")
    private Long minimumOrderQuantity;
    
	@DefaultValue(value = "0")
	private Long availableQuantity;
	
	@Column(name = "is_local_supplier")	
    private Boolean isLocalSupplier; 
	
	@Column(name = "is_international_supplier")	
    private Boolean isInternationalSupplier;   
    
    public PartRequest(Part part) {
        this.id = part.getId();
        this.partName = part.getPartName();
        this.description = part.getDescription();
        this.supplierName = part.getSupplierName();
        this.categoryType = part.getCategoryType();
        this.minimumOrderQuantity = part.getMinimumOrderQuantity();
        this.thresholdLimit= part.getThresholdLimit();
        this.isLocalSupplier = part.getIsLocalSupplier();
        this.isInternationalSupplier = part.getIsInternationalSupplier();
    }    
}
