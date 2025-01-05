package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao
{   
    @Override
    public void addNewVisit(Long patientId, Long doctorId, LocalDateTime time, String description) {

        // Znajdowanie pacjenta
        PatientEntity patient = findOne(patientId);
        if (patient == null) {
            throw new IllegalArgumentException("No patient found with ID: " + patientId);
        }

        // Znajdowanie doktora
        DoctorEntity doctor = entityManager.find(DoctorEntity.class, doctorId);
        if (doctor == null) {
            throw new IllegalArgumentException("No doctor found with ID: " + doctorId);
        }

        // Tworzenie nowej wizyty
        VisitEntity visit = new VisitEntity();
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setTime(time);
        visit.setDescription(description); 

        // Dodanie wizyty do pacjenta
        patient.getVisits().add(visit);

        // Zapisanie zmian
        update(patient);
    }
}