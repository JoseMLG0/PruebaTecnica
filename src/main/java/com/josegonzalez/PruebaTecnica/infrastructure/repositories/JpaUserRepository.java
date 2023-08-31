package com.josegonzalez.PruebaTecnica.infrastructure.repositories;

import com.josegonzalez.PruebaTecnica.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {


    @Query(value = "SELECT * FROM User ORDER BY id LIMIT :pagina OFFSET :total", nativeQuery = true)
    List<UserEntity> findPaginated(Integer total, Integer pagina);

}
