/*
package com.validation.patient_validation.domain.validator;




import com.validation.patient_validation.domain.Patient;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class PatientValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Patient.class.equals(clazz);
    }

    @Override
    public void validate(Object o, Errors e) {

        Patient p = (Patient) o;


        if (p.getName() == null || !p.getName().matches("[A-Z][a-z]+") || p.getName().isEmpty()) {
            e.rejectValue("name", "Name error validation !");
        }
        if (p.getSurname() == null || p.getSurname().isEmpty() || !p.getSurname().matches("[A-Z]+\\s?[A-Z]*")) {
            e.rejectValue("surname", "Surname error validation !");
        }
        if (p.getBirthDate() == null || p.getBirthDate().isBefore(LocalDate.of(31, 12, 1945))) {
            e.rejectValue("birthDate", "BirthDate error validation !");
        }
       */
/* if (p.getPESEL() == null || p.getPESEL().isEmpty() || !p.getPESEL().matches("[0-9]{2}[0-3][0][1-9]||[1][0-2][01]||[0-2][0-9]")) {//todo dodac jeszcze wage

        }*//*


    }
*/
/*    public boolean checkPESEL(String pesel){




        return ;
    }*//*

}
*/
