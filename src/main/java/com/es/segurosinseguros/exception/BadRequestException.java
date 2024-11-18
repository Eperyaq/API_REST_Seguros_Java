package com.es.segurosinseguros.exception;

public class BadRequestException extends RuntimeException{

    private static final String DESCRIPCION = "Bad request (400)";


    public BadRequestException(String mensaje){
        super(DESCRIPCION + ". " + mensaje);
    }
}
