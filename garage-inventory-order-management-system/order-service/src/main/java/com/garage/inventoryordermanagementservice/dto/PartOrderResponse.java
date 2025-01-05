package com.garage.inventoryordermanagementservice.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.garage.inventoryordermanagementservice.entity.Part;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartOrderResponse {

    private Long id;

    private Long orderQuantity;

    private LocalDateTime orderTime;
    
    private String supplierName;
    
    private String orderStatus;
    
    private Part part;
    
    
    
}
