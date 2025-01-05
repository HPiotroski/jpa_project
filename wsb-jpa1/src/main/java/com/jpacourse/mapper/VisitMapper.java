package com.jpacourse.mapper;

import java.util.stream.Collectors;

import com.jpacourse.dto.VisitTO;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import com.jpacourse.persistence.entity.VisitEntity;

public class VisitMapper {
    public static VisitTO toVisitTO(VisitEntity visitEntity) {
        VisitTO visitTO = new VisitTO();
        visitTO.setVisitDate(visitEntity.getVisitDate());
        visitTO.setDoctorName(visitEntity.getDoctor().getFirstName());
        visitTO.setDoctorSurname(visitEntity.getDoctor().getLastName());
        visitTO.setTreatmentTypes(visitEntity.getTreatments().stream()
                .map(MedicalTreatmentEntity::getType)
                .collect(Collectors.toList()));
        return visitTO;
    }
}
