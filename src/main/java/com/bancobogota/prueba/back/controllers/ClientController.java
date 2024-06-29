package com.bancobogota.prueba.back.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @GetMapping("/client")
    public ResponseEntity<?> getClientInfo(@RequestParam String documentType, @RequestParam String documentNumber) {
        
    }
}