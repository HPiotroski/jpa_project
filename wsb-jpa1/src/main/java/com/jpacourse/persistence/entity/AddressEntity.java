package com.jpacourse.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String city;

	private String addressLine1;

	private String addressLine2;

	private String postalCode;

	// RELACJA PACJENT-ADRESY
	@ManyToOne
	private PatientEntity patient;

	// GETTERY I SETTERY DO RELACJI PACJENT-ADRESY
	public PatientEntity getPatient() {
		return patient;
	}
	
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	// RELACJA DOKTOR-ADRESY
	@ManyToOne
	private DoctorEntity doctor;

	// GETTERY I SETTERY DO RELACJI DOKTOR-ADRESY
	public DoctorEntity getDoctor() {
		return doctor;
	}
	
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
