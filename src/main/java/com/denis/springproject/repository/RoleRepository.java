package com.denis.springproject.repository;

import com.denis.springproject.model.entity.Role;
import com.denis.springproject.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Role findByName(String name);
}
