package com.bancobogota.prueba.back.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bancobogota.prueba.back.Repository.ClientRepository;
import com.bancobogota.prueba.back.models.entity.Client;

public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client findByDocumentNumberAndDocumentType(Long documentNumber, String documentType) {
        return clientRepository.findByDocumentNumberAndDocumentType(documentNumber, documentType);
        //throw new UnsupportedOperationException("Unimplemented method 'findByDocumentNumberAndDocumentType'");
    }
}