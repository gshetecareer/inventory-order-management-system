package com.garage.inventorystockmanagementservice.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

	private int status;
	private String field;
	private String message;
	private long timeStamp;
}
