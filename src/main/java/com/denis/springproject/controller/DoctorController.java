package com.denis.springproject.controller;

import com.denis.springproject.model.entity.User;
import com.denis.springproject.repository.DoctorRepository;
import com.denis.springproject.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorService doctorService;

    @GetMapping("/doctors")
    public String getDoctors(Model model) {
        List<User> listDoctors = doctorService.listDoctorAll();
        model.addAttribute("listDoctors", listDoctors);
        return "doctors";
    }
}
