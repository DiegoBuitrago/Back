package com.bancobogota.prueba.back.service;

import com.bancobogota.prueba.back.models.entity.Client;

public interface ClientService {
    Client findByDocumentNumberAndDocumentType(String documentNumber, String documentType);
}