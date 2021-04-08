package com.example.registration.controller;

import com.example.registration.model.Users;
import com.example.registration.model.dto.UsersDto;
import com.example.registration.service.UserServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class UsersController {
    private final UserServiceImpl userServiceImpl;

    public UsersController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return userServiceImpl.findAll();
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable(value = "id") Long id) {
        return userServiceImpl.findById(id);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> createUsers(@RequestBody UsersDto users) {
        if (users == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userServiceImpl.saveUsers(users), new HttpHeaders(), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
    public ResponseEntity<?> updateUser(@PathVariable(value = "id") Long id, @RequestBody Users user) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userServiceImpl.updateUsers(id, user);
        return new ResponseEntity<>(user, new HttpHeaders(), HttpStatus.OK);
    }
}
