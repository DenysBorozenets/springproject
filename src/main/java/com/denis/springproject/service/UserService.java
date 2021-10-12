package com.denis.springproject.service;


import com.denis.springproject.exception.UserNotFoundException;
import com.denis.springproject.model.entity.User;
import com.denis.springproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listAll() {
        return (List<User>) userRepository.findAll();
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
}
