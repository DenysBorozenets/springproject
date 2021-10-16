package com.denis.springproject.repository;

import com.denis.springproject.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.name LIKE %?1%")
    List<User> findAllByRoles(String name);
}
