package com.jpacourse.persistence.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(nullable = false)
    private LocalDateTime time;

    /* ZWIĄZEK DWUKIERUNKOWY WIZYTA-LECZENIE
     * Rodzicem jest MedicalTreatmentEntity
     * Dzieckiem jest VisitEntity
     */
    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MedicalTreatmentEntity> treatments;

    /* ZWIĄZEK JEDNOKIERUNKOWY WIZYTA-LEKARZ
     * Lekarzem jest DoctorEntity
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCTOR_ID", nullable = false)
    private DoctorEntity doctor;

    /* ZWIĄZEK JEDNOKIERUNKOWY WIZYTA-PACJENT
     * Pacjentem jest PatientEntity
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PATIENT_ID", nullable = false)
    private PatientEntity patient;

    // GETTERY I SETTERY

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<MedicalTreatmentEntity> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<MedicalTreatmentEntity> treatments) {
        this.treatments = treatments;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

	    public LocalDate getVisitDate() {
        return time != null ? time.toLocalDate() : null;
    }

}
