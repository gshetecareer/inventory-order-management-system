package com.garage.inventoryordermanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author 
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * @param ex
     * @return
     */
    @ExceptionHandler(PartNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataFoundException(PartNotFoundException ex) {

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse.builder()
                .timeStamp(System.currentTimeMillis())
                .field(ex.getErrorName())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getErrorDescription())
                .build());
    }
    
    @ExceptionHandler(PartFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(PartFoundException ex) {

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse.builder()
                .timeStamp(System.currentTimeMillis())
                .field(ex.getErrorName())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getErrorDescription())
                .build());
    }
    
    @ExceptionHandler(MandatoryRequestFieldMissingException.class)
    public ResponseEntity<ErrorResponse> handleMandatoryReqInputData(MandatoryRequestFieldMissingException ex) {

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse.builder()
                .timeStamp(System.currentTimeMillis())
                .field(ex.getErrorName())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getErrorDescription())
                .build());
    }
    
    @ExceptionHandler(OrderFailedException.class)
    public ResponseEntity<ErrorResponse> orderFailed(OrderFailedException ex) {

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ErrorResponse.builder()
                .timeStamp(System.currentTimeMillis())
                .field(ex.getErrorName())
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getErrorDescription())
                .build());
    }

}
