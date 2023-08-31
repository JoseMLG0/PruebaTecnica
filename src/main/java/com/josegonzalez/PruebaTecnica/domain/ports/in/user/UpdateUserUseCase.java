package com.josegonzalez.PruebaTecnica.domain.ports.in.user;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;

import java.util.Optional;

public interface UpdateUserUseCase {
    Optional<UserModel> updateUser(Long id, UserModel user);
}
