package com.bancobogota.prueba.back.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bancobogota.prueba.back.exception.BadRequestException;
import com.bancobogota.prueba.back.exception.ClientNotFoundException;
import com.bancobogota.prueba.back.exception.InvalidDocumentTypeException;
import com.bancobogota.prueba.back.models.entity.Client;
import com.bancobogota.prueba.back.models.utility.DocumentType;
import com.bancobogota.prueba.back.repository.ClientRepository;

public class ClientServiceImpl implements ClientService{
    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByDocumentNumberAndDocumentType(String documentNumber, String documentType) {
        if (!documentType.equals(DocumentType.CEDULA.getValue()) && !documentType.equals(DocumentType.PASAPORTE.getValue())) {
            logger.error("Invalid document type: {}", documentType);
            throw new InvalidDocumentTypeException("Invalid document type: " + documentType);
        }
        Long docNumber;
        try {
            docNumber = Long.parseLong(documentNumber);
        } catch (NumberFormatException e) {
            logger.error("Document number must be a valid number: {}", documentNumber);
            throw new BadRequestException("Document number must be a valid number");
        }
        Client client = clientRepository.findByDocumentNumberAndDocumentType(docNumber, documentType);
        if (client == null) {
            logger.warn("Client not found for documentNumber: {}", documentNumber);
            throw new ClientNotFoundException("Client not found for documentNumber: " + documentNumber);
        }
        return client;
    }
}