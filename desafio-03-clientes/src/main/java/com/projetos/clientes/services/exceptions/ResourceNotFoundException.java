package com.projetos.clientes.services.exceptions;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }


}
