package com.josegonzalez.PruebaTecnica.domain.exception.employee;

public class NumberAlreadyExistsException extends RuntimeException {

    public NumberAlreadyExistsException(String number) {
        super("El numero de usuario '" + number + "' ya existe.");
    }
}