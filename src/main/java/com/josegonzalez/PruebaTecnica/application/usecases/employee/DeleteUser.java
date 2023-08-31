package com.josegonzalez.PruebaTecnica.application.usecases.employee;

import com.josegonzalez.PruebaTecnica.domain.ports.in.user.DeleteUserUseCase;
import com.josegonzalez.PruebaTecnica.domain.ports.out.UserRepositoryPort;

public class DeleteUser implements DeleteUserUseCase {

    private final UserRepositoryPort userRepositoryPort;


    public DeleteUser(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public boolean deleteUser(Long id) {
        return userRepositoryPort.deleteById(id);
    }
}
