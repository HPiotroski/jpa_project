package com.jpacourse.persistence.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jpacourse.persistence.entity.PatientEntity;


public interface PatientDao extends Dao<PatientEntity, Long> {

    void addNewVisit(Long patientId, Long doctorID, LocalDateTime time, String description);
    
}