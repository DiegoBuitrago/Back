package com.bancobogota.prueba.back.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bancobogota.prueba.back.models.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{
    Client findByDocumentNumberAndDocumentType(Long documentNumber, String documentType);
}