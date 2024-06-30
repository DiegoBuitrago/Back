package com.bancobogota.prueba.back;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bancobogota.prueba.back.exception.BadRequestException;
import com.bancobogota.prueba.back.exception.ClientNotFoundException;
import com.bancobogota.prueba.back.exception.InvalidDocumentTypeException;
import com.bancobogota.prueba.back.models.entity.Client;
import com.bancobogota.prueba.back.repository.ClientRepository;
import com.bancobogota.prueba.back.service.ClientServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientServiceImpl;

    private Client client;

    @BeforeEach
    public void setup() {
        client = new Client();
        client.setDocumentNumber(23445322L);
        client.setDocumentType("C");
        client.setFirstName("Juan");
        client.setMiddleName("Carlos");
        client.setLastName("Perez");
        client.setSecondLastName("Gomez");
        client.setPhone("1234567890");
        client.setAddress("Calle 12 #45-67");
        client.setCity("Medellin");
    }

    @Test
    public void testFindByDocumentNumberAndDocumentTypeSuccess() {
        when(clientRepository.findByDocumentNumberAndDocumentType(23445322L, "C"))
                .thenReturn(client);

        Client foundClient = clientServiceImpl.findByDocumentNumberAndDocumentType("23445322", "C");

        assertNotNull(foundClient);
        assertEquals("Juan", foundClient.getFirstName());
        assertEquals("Carlos", foundClient.getMiddleName());
        assertEquals("Perez", foundClient.getLastName());
        assertEquals("Gomez", foundClient.getSecondLastName());
        assertEquals("1234567890", foundClient.getPhone());
        assertEquals("Calle 12 #45-67", foundClient.getAddress());
        assertEquals("Medellin", foundClient.getCity());
    }

    @Test
    public void testFindByDocumentNumberAndDocumentTypeInvalidDocumentType() {
        InvalidDocumentTypeException exception = assertThrows(
                InvalidDocumentTypeException.class,
                () -> clientServiceImpl.findByDocumentNumberAndDocumentType("23445322", "X")
        );

        assertEquals("Invalid document type: X", exception.getMessage());
    }

    @Test
    public void testFindByDocumentNumberAndDocumentTypeInvalidDocumentNumber() {
        BadRequestException exception = assertThrows(
                BadRequestException.class,
                () -> clientServiceImpl.findByDocumentNumberAndDocumentType("invalidNumber", "C")
        );

        assertEquals("Document number must be a valid number", exception.getMessage());
    }

    @Test
    public void testFindByDocumentNumberAndDocumentTypeClientNotFound() {
        when(clientRepository.findByDocumentNumberAndDocumentType(12345678L, "C"))
                .thenReturn(null);

        ClientNotFoundException exception = assertThrows(
                ClientNotFoundException.class,
                () -> clientServiceImpl.findByDocumentNumberAndDocumentType("12345678", "C")
        );

        assertEquals("Client not found for documentNumber: 12345678", exception.getMessage());
    }
}