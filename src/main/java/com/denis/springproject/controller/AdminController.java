package com.denis.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class AdminController {

    @GetMapping("/admin")
    public String getAdminPage(Model model) {
        model.addAttribute("title", "Main page for admin");
        return "admin";
    }

    @GetMapping("/admin/patient")
    public String getPatient() {
        return "patient";
    }
}
