package com.josegonzalez.PruebaTecnica.application.services.employee;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;
import com.josegonzalez.PruebaTecnica.domain.ports.in.user.CreateUserUseCase;
import com.josegonzalez.PruebaTecnica.domain.ports.in.user.DeleteUserUseCase;
import com.josegonzalez.PruebaTecnica.domain.ports.in.user.RetrieveUserUseCase;
import com.josegonzalez.PruebaTecnica.domain.ports.in.user.UpdateUserUseCase;

import java.util.List;
import java.util.Optional;

public class UserService implements CreateUserUseCase, UpdateUserUseCase, DeleteUserUseCase, RetrieveUserUseCase {

    private final CreateUserUseCase createUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final RetrieveUserUseCase retrieveUserUseCase;

    public UserService(CreateUserUseCase createUserUseCase, UpdateUserUseCase updateUserUseCase, DeleteUserUseCase deleteUserUseCase, RetrieveUserUseCase retrieveUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.retrieveUserUseCase = retrieveUserUseCase;
    }

    @Override
    public UserModel createUser(UserModel user) {
        return createUserUseCase.createUser(user);
    }

    @Override
    public boolean deleteUser(Long id) {
        return deleteUserUseCase.deleteUser(id);
    }

    @Override
    public Optional<UserModel> getUser(Long id) {
        return retrieveUserUseCase.getUser(id);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return retrieveUserUseCase.getAllUsers();
    }

    @Override
    public List<UserModel> getPaginated(Integer size, Integer page) {
        return retrieveUserUseCase.getPaginated(size, page);
    }

    @Override
    public Optional<UserModel> updateUser(Long id, UserModel user) {
        return updateUserUseCase.updateUser(id, user);
    }


}
