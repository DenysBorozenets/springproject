package com.denis.springproject.repository;

import com.denis.springproject.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByEmail(String email);
      Long countById(Long id);

}
