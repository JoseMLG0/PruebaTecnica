package com.josegonzalez.PruebaTecnica.application.usecases.employee;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;
import com.josegonzalez.PruebaTecnica.domain.ports.in.user.CreateUserUseCase;
import com.josegonzalez.PruebaTecnica.domain.ports.out.UserRepositoryPort;

public class CreateUser implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;


    public CreateUser(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }


    @Override
    public UserModel createUser(UserModel employee) {
        // OPERACIONES ANTES DE GUARDAR
        try {
            return userRepositoryPort.save(employee);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
