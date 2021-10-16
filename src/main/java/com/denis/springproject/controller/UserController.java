package com.denis.springproject.controller;

import com.denis.springproject.exception.UserNotFoundException;
import com.denis.springproject.model.entity.Role;
import com.denis.springproject.model.entity.User;
import com.denis.springproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<User> users = userService.listAll();
        model.addAttribute("listUsers", users);
        return "users";
    }

    @GetMapping("/users/add")
    public String addUser(Model model) {
        List<Role> roles = userService.getRoles();
        model.addAttribute("listRoles", roles);
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add new user");
        return "user_add";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes redirect) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userService.save(user);
        redirect.addFlashAttribute("message", "The user has been saved successfully");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model, RedirectAttributes redirect) {
        try {
            User user = userService.getId(id);
            List<Role> roles = userService.getRoles();
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodePassword = encoder.encode(user.getPassword());
            user.setPassword(encodePassword);
            model.addAttribute("user", user);
            model.addAttribute("listRoles", roles);
            model.addAttribute("pageTitle", "Edit user " + id );
            return "user_add";
        } catch (UserNotFoundException e) {
            redirect.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model, RedirectAttributes redirect) {
        try {
            userService.delete(id);
            redirect.addFlashAttribute("message", "The user " + id + " has been successfully deleted");
        } catch (UserNotFoundException e) {
            redirect.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/users";
    }

    @GetMapping("/403")
    public String errorFourZeroThree() {
        return "403";
    }
}
