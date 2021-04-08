package com.example.registration.service;

import com.example.registration.model.Users;
import com.example.registration.model.dto.UsersDto;
import com.example.registration.repositories.UserRepositories;
import com.example.registration.utils.ConvertUsers;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositories userRepositories;
    private final ConvertUsers convertUsers;

    public UserServiceImpl(UserRepositories userRepositories, ConvertUsers convertUsers) {
        this.userRepositories = userRepositories;
        this.convertUsers = convertUsers;
    }

    @Override
    public Users findById(Long id) {
        return userRepositories.findById(id).orElse(null);
    }

    @Override
    public List<Users> findByFirstName(String firstName) {
        return userRepositories.findByFirstName(firstName);
    }

    @Override
    public List<Users> findByLastName(String lastName) {
        return userRepositories.findByLastName(lastName);
    }

    @Override
    public List<Users> findAll() {
        return userRepositories.findAll();
    }

    @Override
    public List<Users> findByAge(Long age) {
        return userRepositories.findByAge(age);
    }

    @Override
    public List<Users> findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepositories.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public void updateUsers(Long id, Users usersUpdate) {
        Users users = userRepositories.findById(id).orElse(null);
        if (users != null) {
            users.setFirstName(usersUpdate.getFirstName());
            users.setLastName(usersUpdate.getLastName());
            users.setAge(usersUpdate.getAge());
            users.setEditDate(LocalDate.now());
            userRepositories.save(users);
        }

    }

    @Override
    public Users saveUsers(UsersDto usersDto) {
        return userRepositories.save(convertUsers.convertUsersDtoToUsers(usersDto));
    }

    @Override
    public void deleteUsersById(Long id) {
        userRepositories.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepositories.deleteAll();
    }
}
