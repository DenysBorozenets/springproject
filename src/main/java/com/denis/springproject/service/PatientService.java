package com.denis.springproject.service;

import com.denis.springproject.model.entity.User;
import com.denis.springproject.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    public List<User> listPatientAll() {
        return patientRepository.findAllByRoles("PATIENT");
    }
}
