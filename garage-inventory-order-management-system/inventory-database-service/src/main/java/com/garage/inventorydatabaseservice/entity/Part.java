package com.garage.inventorydatabaseservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="GARAGE_PART")
public class Part{

	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "part_name")
    private String partName;
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "supplier_name")
    private String supplierName;
	
	@Column(name = "category_type")
    private String categoryType;
	
	@Column(name = "threshold_limit")
    private Long thresholdLimit;
	
	@Column(name = "available_quantity")
    private Long availableQuantity;
	
	@Column(name = "minimum_order_quantity")
    private Long minimumOrderQuantity; 
	
	@Column(name = "price")
    private Float price;
	
	@Column(name = "is_local_supplier")	
    private Boolean isLocalSupplier; 
	
	@Column(name = "is_international_supplier")	
    private Boolean isInternationalSupplier;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public Long getThresholdLimit() {
		return thresholdLimit;
	}

	public void setThresholdLimit(Long thresholdLimit) {
		this.thresholdLimit = thresholdLimit;
	}

	public Long getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Long getMinimumOrderQuantity() {
		return minimumOrderQuantity;
	}

	public void setMinimumOrderQuantity(Long minimumOrderQuantity) {
		this.minimumOrderQuantity = minimumOrderQuantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Boolean getIsLocalSupplier() {
		return isLocalSupplier;
	}

	public void setIsLocalSupplier(Boolean isLocalSupplier) {
		this.isLocalSupplier = isLocalSupplier;
	}

	public Boolean getIsInternationalSupplier() {
		return isInternationalSupplier;
	}

	public void setIsInternationalSupplier(Boolean isInternationalSupplier) {
		this.isInternationalSupplier = isInternationalSupplier;
	}

	@Override
	public String toString() {
		return "Part [id=" + id + ", partName=" + partName + ", description=" + description + ", supplierName="
				+ supplierName + ", categoryType=" + categoryType + ", thresholdLimit=" + thresholdLimit
				+ ", availableQuantity=" + availableQuantity + ", minimumOrderQuantity=" + minimumOrderQuantity
				+ ", price=" + price + ", isLocalSupplier=" + isLocalSupplier + ", isInternationalSupplier="
				+ isInternationalSupplier + "]";
	}
}