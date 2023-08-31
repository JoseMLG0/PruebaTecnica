package com.josegonzalez.PruebaTecnica.application.usecases.employee;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;
import com.josegonzalez.PruebaTecnica.domain.ports.in.user.UpdateUserUseCase;
import com.josegonzalez.PruebaTecnica.domain.ports.out.UserRepositoryPort;

import java.util.Optional;

public class UpdateUser implements UpdateUserUseCase {
    private final UserRepositoryPort userRepositoryPort;


    public UpdateUser(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<UserModel> updateUser(Long id, UserModel employee) {
        return userRepositoryPort.update(id, employee);
    }
}
