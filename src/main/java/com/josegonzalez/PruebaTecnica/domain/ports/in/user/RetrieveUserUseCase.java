package com.josegonzalez.PruebaTecnica.domain.ports.in.user;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;

import java.util.List;
import java.util.Optional;

public interface RetrieveUserUseCase {
    Optional<UserModel> getUser(Long id);
    List<UserModel> getAllUsers();
    List<UserModel> getPaginated(Integer page, Integer size);
}
