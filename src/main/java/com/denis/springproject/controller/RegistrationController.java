package com.denis.springproject.controller;

import com.denis.springproject.model.entity.User;
import com.denis.springproject.repository.UserRepository;
import com.denis.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration_form";
    }

    @PostMapping("/process_registration")
    public String saveUser(User user) {
        userService.saveUserWithDefaultRole(user);
        return "registration_success";
    }

}
