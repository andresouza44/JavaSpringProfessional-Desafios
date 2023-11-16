package com.projetos.clientes.dto;

public class FieldMessager {
    private String fieldName;
    private String message;

    public FieldMessager(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }
    public String getFieldName() {
        return fieldName;
    }
    public String getMessage() {
        return message;
    }
}
