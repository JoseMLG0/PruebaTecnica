package com.josegonzalez.PruebaTecnica.infrastructure.controllers;

import com.josegonzalez.PruebaTecnica.application.services.employee.UserService;
import com.josegonzalez.PruebaTecnica.domain.models.users.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {
    private final UserService userService;


    public UserController(UserService employeeService) {
        this.userService = employeeService;
    }

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserModel employee) {
        try{
            UserModel createdEmployee = userService.createUser(employee);
            return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            System.out.println("Excepción de tiempo de ejecución: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }catch (Exception e){
            System.out.println("Error Message: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserModel> getById(@PathVariable Long userId){
        return userService.getUser(userId).map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/{total}/{page}")
    public ResponseEntity<List<UserModel>> getPaginated(@PathVariable Integer total, @PathVariable Integer page){
        List<UserModel> users = userService.getPaginated(page, total);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<UserModel>> getAll(){
        List<UserModel> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserModel> update(@PathVariable Long userId, @RequestBody UserModel user){
        return userService.updateUser(userId, user).map(userD -> new ResponseEntity<>(userD, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId){
        if(userService.deleteUser(userId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
