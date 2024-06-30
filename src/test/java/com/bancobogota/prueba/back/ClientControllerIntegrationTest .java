package com.bancobogota.prueba.back;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bancobogota.prueba.back.repository.ClientRepository;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository clientRepository;

    @BeforeEach
    public void setup() {
        
    }

    @Test
    public void testGetClientInfo() throws Exception {
        mockMvc.perform(get("/client")
                        .param("documentType", "C")
                        .param("documentNumber", "23445322")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.primer_nombre").value("Juan"))
                .andExpect(jsonPath("$.segundo_nombre").value("Carlos"))
                .andExpect(jsonPath("$.primer_apellido").value("Perez"))
                .andExpect(jsonPath("$.segundo_apellido").value("Gomez"))
                .andExpect(jsonPath("$.telefono").value("1234567890"))
                .andExpect(jsonPath("$.direccion").value("Calle 12 #45-67"))
                .andExpect(jsonPath("$.ciudad").value("Medellin"));
    }

    @Test
    public void testGetClientInfoInvalidDocumentType() throws Exception {
        mockMvc.perform(get("/client")
                        .param("documentType", "X")
                        .param("documentNumber", "23445322")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Invalid document type: X"));
    }

    @Test
    public void testGetClientInfoClientNotFound() throws Exception {
        mockMvc.perform(get("/client")
                        .param("documentType", "C")
                        .param("documentNumber", "12345678")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Client not found for documentNumber: 12345678"));
    }
}