package com.example.registration.utils;

import com.example.registration.model.Users;
import com.example.registration.model.dto.UsersDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ConvertUsers {

    public Users convertUsersDtoToUsers(UsersDto usersDto) {
        Users users = new Users();
        users.setFirstName(usersDto.getFirstName());
        users.setLastName(usersDto.getLastName());
        users.setAge(usersDto.getAge());
        users.setRegistrationDate(LocalDate.now());
        users.setEditDate(LocalDate.now());
        return users;
    }

    public UsersDto convertUserToUserDto(Users users) {
        UsersDto usersDto = new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setFirstName(users.getFirstName());
        usersDto.setLastName(users.getFirstName());
        usersDto.setAge(users.getAge());
        return usersDto;
    }
}
