package com.jpacourse.persistence.entity;

import com.jpacourse.persistence.enums.Specialization;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String doctorNumber;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Specialization specialization;

	/* ZWIĄZEK JEDNOKIERUNKOWY DOKTOR-WIZYTA
	* Rodzicem jest Doktor
	* Dzieckiem jest Wizyta
	* Relacja jednokierunkowa od strony rodzica
	*/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID")
    private List<VisitEntity> visits;

	// GETTER I SETTER
	public List<VisitEntity> getVisits() {
        return visits;
    }

	public void setVisits(List<VisitEntity> visits) {
        this.visits = visits;
    }

	/* ZWIĄZEK DWUKIERUNKOWY DOKTOR-ADRESY
	* Rodzicem jest DoctorEntity
	* Dzieckiem jest AddressEntity
	* Relacja dwukierunkowa
	*/
	@OneToMany(mappedBy = "doctor")
	private List<AddressEntity> addresses;

	// GETTERY I SETTERY DO RELACJI DOKTOR-ADRESY
	public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

}
