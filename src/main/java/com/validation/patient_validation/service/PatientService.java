package com.validation.patient_validation.service;


import com.validation.patient_validation.domain.Patient;
import com.validation.patient_validation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> getAllPatients() {
        return repository.findAll();
    }

    public void deletePatient(Long id) {
        repository.delete(id);
    }

    public Patient updatePatient(Patient patient) {
        return repository.save(patient);
    }

    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }
}
