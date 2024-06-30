package com.bancobogota.prueba.back.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "document_number", nullable = false, unique = true)
    private Long documentNumber;
    @Column(name = "document_type", length = 1)
    private String documentType;
    @Column(name = "firstName", length = 20)
    private String firstName;
    @Column(name = "middleName", length = 20)
    private String middleName;
    @Column(name = "lastName", length = 20)
    private String lastName;
    @Column(name = "secondLastName", length = 20)
    private String secondLastName;
    @Column(name = "phone", length = 14)
    private String phone;
    @Column(name = "address", length = 40)
    private String address;
    @Column(name = "city", length = 20)
    private String city;
}