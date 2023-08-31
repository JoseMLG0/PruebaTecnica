package com.josegonzalez.PruebaTecnica.application.usecases.employee;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;
import com.josegonzalez.PruebaTecnica.domain.ports.in.user.RetrieveUserUseCase;
import com.josegonzalez.PruebaTecnica.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveUser implements RetrieveUserUseCase {
    private final UserRepositoryPort userRepositoryPort;


    public RetrieveUser(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public Optional<UserModel> getUser(Long id) {
        return userRepositoryPort.findById(id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepositoryPort.findAll();
    }

    @Override
    public List<UserModel> getPaginated(Integer page, Integer size) {
        return userRepositoryPort.findPaginated(page, size);
    }
}
