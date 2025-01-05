package com.garage.inventorystockmanagementservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MandatoryRequestFieldMissingException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private int httpStatusCode; 
	private String errorName;
	private String errorDescription;
}
