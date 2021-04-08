package com.example.registration.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long age;
}
