package com.validation.patient_validation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

import static com.validation.patient_validation.patienValidationPatterns.PatientPatterns.namePattern;
import static com.validation.patient_validation.patienValidationPatterns.PatientPatterns.surnamePattern;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Pattern(regexp = namePattern, message = "Name validation error.")
    private String name;
    @Pattern(regexp = surnamePattern, message = "Surname validation error.")
    private String surname;
    @NotBlank(message = "Birthdate field con not be empty")
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    //@NotEmpty
    private Gender gender;
    @org.hibernate.validator.constraints.pl.PESEL
    private String PESEL;
    //multipart transcient
    @Transient
    //@NotBlank//???
    //@NotEmpty
    private MultipartFile multipartFile;
    private String filePath;

}
