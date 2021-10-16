package com.denis.springproject.service;

import com.denis.springproject.model.entity.User;
import com.denis.springproject.repository.DoctorRepository;
import com.denis.springproject.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public List<User> listDoctorAll() {
        return doctorRepository.findAll("DOCTOR");
    }
}
