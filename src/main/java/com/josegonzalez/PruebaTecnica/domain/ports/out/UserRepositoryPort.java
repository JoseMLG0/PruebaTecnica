package com.josegonzalez.PruebaTecnica.domain.ports.out;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {
    UserModel save(UserModel employee) throws Exception;
    Optional<UserModel> findById(Long id);
    List<UserModel> findAll();
    List<UserModel> findPaginated(Integer page, Integer size);
    Optional<UserModel> update(Long id, UserModel employee);
    boolean deleteById(Long id);
}
