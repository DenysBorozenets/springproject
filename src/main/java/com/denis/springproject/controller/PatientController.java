package com.denis.springproject.controller;

import com.denis.springproject.model.entity.User;
import com.denis.springproject.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public String getDoctors(Model model) {
        List<User> listPatients = patientService.listPatientAll();
        model.addAttribute("listPatients", listPatients);
        return "patients";
    }
}
