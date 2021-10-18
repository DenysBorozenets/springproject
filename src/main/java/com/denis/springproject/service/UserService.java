package com.denis.springproject.service;


import com.denis.springproject.exception.UserNotFoundException;
import com.denis.springproject.model.entity.Role;
import com.denis.springproject.model.entity.User;
import com.denis.springproject.repository.RoleRepository;
import com.denis.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Page<User> listAll(int pageNumber, String sortField, String sortDirection) {
        Sort sort = Sort.by(sortField);
        sort = sortDirection.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNumber - 1,5, sort);
        return userRepository.findAll(pageable);
    }

    public void save(User user){
        userRepository.save(user);
    }

    public User getId(Long id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException("Can`t find user with ID" + id);
    }

    public void delete(Long id) throws  UserNotFoundException{
        Long count = userRepository.countById(id);
        if (count==null || count == 0){
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
    }

    public void saveUserWithDefaultRole(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        Role role = roleRepository.findByName("User");
        user.addRole(role);
        userRepository.save(user);
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
