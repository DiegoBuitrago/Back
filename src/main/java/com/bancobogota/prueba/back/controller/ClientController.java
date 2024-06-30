package com.bancobogota.prueba.back.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bancobogota.prueba.back.models.dto.ClientResponse;
import com.bancobogota.prueba.back.models.entity.Client;
import com.bancobogota.prueba.back.service.ClientServiceImpl;

@RestController
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @GetMapping("/client")
    public ResponseEntity<?> getClientInfo(@RequestParam String documentType, @RequestParam String documentNumber) {
        logger.info("Received request for: client, documentType: {} and documentNumber: {}", documentType, documentNumber);
        
        Client client = clientServiceImpl.findByDocumentNumberAndDocumentType(documentNumber, documentType);
        return new ResponseEntity<>(ClientResponse.builder().firstName(client.getFirstName()).middleName(client.getMiddleName()).lastName(client.getLastName()).secondLastName(client.getSecondLastName()).phone(client.getPhone()).address(client.getAddress()).city(client.getCity()).build(), HttpStatus.OK);
    }
}