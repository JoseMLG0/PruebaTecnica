package com.josegonzalez.PruebaTecnica.infrastructure.config;

import com.josegonzalez.PruebaTecnica.application.services.employee.UserService;
import com.josegonzalez.PruebaTecnica.application.usecases.employee.CreateUser;
import com.josegonzalez.PruebaTecnica.application.usecases.employee.DeleteUser;
import com.josegonzalez.PruebaTecnica.application.usecases.employee.RetrieveUser;
import com.josegonzalez.PruebaTecnica.application.usecases.employee.UpdateUser;
import com.josegonzalez.PruebaTecnica.domain.ports.out.UserRepositoryPort;
import com.josegonzalez.PruebaTecnica.domain.ports.out.ExternalServicePort;
import com.josegonzalez.PruebaTecnica.infrastructure.adapters.ExternalServiceAdapter;
import com.josegonzalez.PruebaTecnica.infrastructure.repositories.JpaUserRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort){
        return new UserService(
                new CreateUser(userRepositoryPort),
                new UpdateUser(userRepositoryPort),
                new DeleteUser(userRepositoryPort),
                new RetrieveUser(userRepositoryPort)
        );
    }
    @Primary
    @Bean
    public UserRepositoryPort userRepositoryAdapter(JpaUserRepositoryAdapter jpaUserRepositoryAdapter){
        return jpaUserRepositoryAdapter;
    }
    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }

}
