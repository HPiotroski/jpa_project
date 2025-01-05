package com.jpacourse.mapper;

import java.util.stream.Collectors;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.entity.PatientEntity;

public class PatientMapper {
    public static PatientTO toPatientTO(PatientEntity patientEntity) {
        PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setIsActive(patientEntity.getIsActive());
        patientTO.setVisits(patientEntity.getVisits().stream()
                .map(VisitMapper::toVisitTO)
                .collect(Collectors.toList()));
        return patientTO;
    }
}

