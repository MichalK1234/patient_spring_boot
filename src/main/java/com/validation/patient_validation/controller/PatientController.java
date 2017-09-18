package com.validation.patient_validation.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.validation.patient_validation.domain.Gender;
import com.validation.patient_validation.domain.Patient;
import com.validation.patient_validation.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PatientController {

    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String welcome() {
        return "home";
    }

    @GetMapping("/patient/select/all")
    public String selectAllPatients(Model model) throws JsonProcessingException {

        List<Patient> patientList = service.getAllPatients();
        ObjectMapper objectMapper = new ObjectMapper();
        String patients = objectMapper.writeValueAsString(patientList);
        model.addAttribute("patients", patients);

        return "patientSelectAll2";

    }

    @GetMapping("/patient/insert")
    public String insertPatientGet(Model model) {

        Patient patient1 = new Patient();
        model.addAttribute("patient", patient1);
        model.addAttribute("genders", Gender.values());

        return "patientInsert";
    }

    @PostMapping("/patient/insert")
    public String insertPatientPost(@Valid @ModelAttribute Patient patient, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "patientInsert";
        }


        return "redirect:/patientSelectAll";
    }

    @DeleteMapping("/patient/delete/{id}")
    public String deletePatientById(@PathVariable("id") Long id) {

        service.deletePatient(id);

        return "redirect:/patientSelectAll";
    }


}
