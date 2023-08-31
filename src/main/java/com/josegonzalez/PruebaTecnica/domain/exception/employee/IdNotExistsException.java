package com.josegonzalez.PruebaTecnica.domain.exception.employee;

public class IdNotExistsException extends RuntimeException {

    public IdNotExistsException(Long id) {
        super("El ID de usuario '" + id + "' no existe.");
    }
}