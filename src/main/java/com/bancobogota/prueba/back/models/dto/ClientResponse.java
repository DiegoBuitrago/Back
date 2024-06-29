package com.bancobogota.prueba.back.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ClientResponse {
    @JsonProperty("primer_nombre")
    private String firstName;
    @JsonProperty("segundo_nombre")
    private String middleName;
    @JsonProperty("primer_apellido")
    private String lastName;
    @JsonProperty("segundo_apellido")
    private String secondLastName;
    @JsonProperty("telefono")
    private String phone;
    @JsonProperty("direccion")
    private String address;
    @JsonProperty("ciudad")
    private String city;
}