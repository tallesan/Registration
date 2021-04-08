package com.example.registration.repositories;

import com.example.registration.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositories extends JpaRepository<Users, Long> {
    Optional<Users> findById(Long Id);
    List<Users> findByFirstName(String firstName);
    List<Users> findByLastName(String lastName);
    List<Users> findByFirstNameAndLastName(String firstName, String lastName);
    List<Users> findByAge(Long age);
}
