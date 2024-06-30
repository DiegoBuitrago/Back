package com.bancobogota.prueba.back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bancobogota.prueba.back.models.dto.MessageResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<MessageResponse> handleClientNotFoundException(ClientNotFoundException ex) {
        return new ResponseEntity<>(MessageResponse.builder().message(ex.getMessage()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidDocumentTypeException.class)
    public ResponseEntity<MessageResponse> handleInvalidDocumentTypeException(InvalidDocumentTypeException ex) {
        return new ResponseEntity<>(MessageResponse.builder().message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageResponse> handleBadRequestException(BadRequestException ex) {
        return new ResponseEntity<>(MessageResponse.builder().message(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleGeneralException(Exception ex) {
        return new ResponseEntity<>(MessageResponse.builder().message("Internal Server Error").build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}