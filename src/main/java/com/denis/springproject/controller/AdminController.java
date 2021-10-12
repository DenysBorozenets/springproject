//package com.denis.springproject.controller;
//
//import com.denis.springproject.model.entity.Patient;
//import com.denis.springproject.repository.PatientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/welcome")
//public class AdminController {
//
//    @Autowired
//    private PatientRepository patientRepository;
//
//    @GetMapping("/admin")
//    public String getAdminPage(Model model) {
//        model.addAttribute("title", "Main page for admin");
//        return "admin";
//    }
//
//    @GetMapping("/admin/patient")
//    public String getPatient(Model model) {
//        Iterable<Patient> patients = patientRepository.findAll();
//        model.addAttribute("patients", patients);
//        return "patient";
//    }
//
//    @GetMapping("/admin/patient/add")
//    public String addPatient() {
//        return "patient-add";
//    }
//
//    @PostMapping("/admin/patient/add")
//    public String addPatient(@RequestParam String email,
//                             @RequestParam String firstName,
//                             @RequestParam String lastName) {
//        Patient patient = new Patient(email, firstName, lastName);
//        patientRepository.save(patient);
//        return "redirect:/welcome/admin/patient";
//    }
//
//    @GetMapping("/admin/patient/{id}")
//    public String patientDetail(@PathVariable(value = "id") long id, Model model) {
//        if (!patientRepository.existsById(id)) {
//            return "redirect:/admin/patient";
//        }
//        Optional<Patient> patient = patientRepository.findById(id);
//        ArrayList<Patient> result = new ArrayList<>();
//        patient.ifPresent(result::add);
//        model.addAttribute("patient", result);
//        return "patient-details";
//    }
//
//    @GetMapping("/admin/patient/{id}/edit")
//    public String patientEdit(@PathVariable(value = "id") long id, Model model) {
//        if (!patientRepository.existsById(id)) {
//            return "redirect:/admin/patient";
//        }
//        Optional<Patient> patient = patientRepository.findById(id);
//        ArrayList<Patient> result = new ArrayList<>();
//        patient.ifPresent(result::add);
//        model.addAttribute("patient", result);
//        return "patient-edit";
//    }
//
//    @PostMapping("/admin/patient/{id}/edit")
//    public String patientUpdate(@PathVariable(name = "id") long id,
//                                @RequestParam String email,
//                                @RequestParam String firstName,
//                                @RequestParam String lastName) {
//        Patient patient = patientRepository.findById(id).orElseThrow();
//        patient.setEmail(email);
//        patient.setFirstName(firstName);
//        patient.setLastName(lastName);
//        patientRepository.save(patient);
//        return "redirect:/welcome/admin/patient";
//    }
//
//    @PostMapping("/admin/patient/{id}/remove")
//    public String patientRemove(@PathVariable(name = "id") long id){
//        Patient patient = patientRepository.findById(id).orElseThrow();
//        patientRepository.delete(patient);
//        return "redirect:/welcome/admin/patient";
//    }
//
//}
