package com.josegonzalez.PruebaTecnica.infrastructure.entities;

import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TCN_NOMBRE", nullable = false)
    private String nombre;
    @Column(name = "TCN_APELLIDO", nullable = false)
    private String apellido;
    @Column(name = "TCN_CORREO", unique = true)
    private String correo;
    @Column(name = "TCN_NACIMIENTO")
    private Date fechaNacimiento;

    public UserEntity() {
    }

    public UserEntity(Long id, String nombre, String apellido, String correo, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public  static UserEntity fromDomainModel(UserModel employee){
        return new UserEntity(employee.getId(), employee.getNombre(), employee.getApellido(), employee.getCorreo(), employee.getFechaNacimiento());
    }

    public UserModel toDomainModel(){
        return new UserModel(id, nombre, apellido, correo, fechaNacimiento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
