package com.example.registration.service;

import com.example.registration.model.Users;
import com.example.registration.model.dto.UsersDto;

import java.util.List;

public interface UserService {
    Users findById(Long id);
    List<Users> findByFirstName(String firstName);
    List<Users> findByLastName(String lastName);
    List<Users> findAll();
    List<Users> findByAge(Long age);
    List<Users> findByFirstNameAndLastName(String firstName, String lastName);
    void updateUsers(Long Id, Users users);
    Users saveUsers(UsersDto usersDto);
    void deleteUsersById(Long id);
    void deleteAllUsers();
}
