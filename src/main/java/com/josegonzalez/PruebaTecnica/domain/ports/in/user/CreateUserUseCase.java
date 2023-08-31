package com.josegonzalez.PruebaTecnica.domain.ports.in.user;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;

public interface CreateUserUseCase {
    UserModel createUser(UserModel user);
}
