package com.josegonzalez.PruebaTecnica.infrastructure.repositories;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;
import com.josegonzalez.PruebaTecnica.domain.ports.out.UserRepositoryPort;
import com.josegonzalez.PruebaTecnica.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository jpaUserRepository;

    public JpaUserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public UserModel save(UserModel employee) {
        UserEntity userEntity = UserEntity.fromDomainModel(employee);
        UserEntity saveUserEntity = jpaUserRepository.save(userEntity);
        return saveUserEntity.toDomainModel();
    }

    @Override
    public Optional<UserModel> findById(Long id) {
        return jpaUserRepository.findById(id).map(UserEntity::toDomainModel);
    }

    @Override
    public List<UserModel> findAll() {
        return jpaUserRepository.findAll().stream().map(UserEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public List<UserModel> findPaginated(Integer page, Integer size) {
        Integer start = (page-1)*size;
        return jpaUserRepository.findPaginated(start, size).stream().map(UserEntity::toDomainModel).collect(Collectors.toList());

    }

    @Override
    public Optional<UserModel> update(Long id, UserModel user) {
        if (jpaUserRepository.existsById(id)){
            user.setId(id);
            UserEntity userEntity = UserEntity.fromDomainModel(user);
            UserEntity updateUserEntity = jpaUserRepository.save(userEntity);
            return  Optional.of(updateUserEntity.toDomainModel());
        }
        // TAMBIEN PUEDO USAR MERGE PARA ACTUALIZARLO
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaUserRepository.existsById(id)){
            jpaUserRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
