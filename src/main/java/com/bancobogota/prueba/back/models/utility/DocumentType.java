package com.bancobogota.prueba.back.models.utility;

public enum DocumentType {
    CEDULA("C"),
    PASAPORTE("P");

    private String value;

    private DocumentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}