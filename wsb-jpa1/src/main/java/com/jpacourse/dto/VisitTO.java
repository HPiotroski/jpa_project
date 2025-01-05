package com.jpacourse.dto;

import java.time.LocalDate;
import java.util.List;

import com.jpacourse.persistence.enums.TreatmentType;

public class VisitTO {
    private LocalDate visitDate;
    private String doctorName;
    private String doctorSurname;
    private List<TreatmentType> treatmentTypes;

    // Getters and Setters
    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSurname() {
        return doctorSurname;
    }

    public void setDoctorSurname(String doctorSurname) {
        this.doctorSurname = doctorSurname;
    }

    public List<TreatmentType> getTreatmentTypes() {
        return treatmentTypes;
    }

    public void setTreatmentTypes(List<TreatmentType> treatmentTypes) {
        this.treatmentTypes = treatmentTypes;
    }
}
