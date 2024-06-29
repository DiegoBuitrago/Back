package com.bancobogota.prueba.back.Service;

import com.bancobogota.prueba.back.models.entity.Client;

public interface ClientService {
    Client findByDocumentNumberAndDocumentType(Long documentNumber, String documentType);
}