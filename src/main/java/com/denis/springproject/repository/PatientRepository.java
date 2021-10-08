package com.denis.springproject.repository;

import com.denis.springproject.model.entity.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
