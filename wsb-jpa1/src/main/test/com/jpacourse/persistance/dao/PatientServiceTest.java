package com.jpacourse.persistance.dao;

import com.jpacourse.dto.PatientTO;
import com.jpacourse.persistence.dao.DoctorDao;
import com.jpacourse.persistence.dao.PatientDao;
import com.jpacourse.persistence.dao.VisitDao;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.enums.Sex;
import com.jpacourse.persistence.enums.TreatmentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import com.jpacourse.service.PatientService;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private DoctorDao doctorDao;

    @Transactional
    @Test
    public void testShouldFindPatientById() {
        // Given
        // When
        PatientTO patient = patientService.findById(1L);

        // Then
        assertThat(patient).isNotNull();
        assertThat(patient.getFirstName()).isEqualTo("Adam");
        assertThat(patient.getLastName()).isEqualTo("Kowalski");
        assertThat(patient.getDateOfBirth()).isEqualTo("1995-07-12");
        assertThat(patient.getSex()).isEqualTo(Sex.MALE);
        assertThat(patient.getTelephoneNumber()).isEqualTo("987987987");
        assertThat(patient.getEmail()).isEqualTo("adam.kowalski@domain.com");
        assertThat(patient.getPatientNumber()).isEqualTo("PT001");
        assertThat(patient.getVisits().size()).isEqualTo(2); // Adam ma 2 wizyty

        // do not base on order
        assertThat(patient.getVisits().get(0).getTime()).isEqualTo("2024-01-05T12:15:00");
        assertThat(patient.getVisits().get(0).getDoctorName()).isEqualTo("Jan");
        assertThat(patient.getVisits().get(0).getDoctorSurname()).isEqualTo("Nowak");
        assertThat(patient.getVisits().get(0).getTreatments().size()).isEqualTo(2); // Adam ma 2 leczenia
        assertThat(patient.getVisits().get(0).getTreatments().get(0)).isEqualTo(TreatmentType.NORMAL); // Kuracja podstawowa
        assertThat(patient.getVisits().get(0).getTreatments().get(1)).isEqualTo(TreatmentType.PREVENTIVE); // Profilaktyka neurologiczna

        assertThat(patient.getVisits().get(1).getTime()).isEqualTo("2024-01-08T11:00:00");
        assertThat(patient.getVisits().get(1).getDoctorName()).isEqualTo("Jan");
        assertThat(patient.getVisits().get(1).getDoctorSurname()).isEqualTo("Nowak");
        assertThat(patient.getVisits().get(1).getTreatments().size()).isEqualTo(1); // Adam ma 1 leczenie
        assertThat(patient.getVisits().get(1).getTreatments().get(0)).isEqualTo(TreatmentType.NORMAL); // Leczenie przeciwbólowe
    }

    @Transactional
    @Test
    public void testShouldRemovePatientAndVisitsButNotDoctors() {
        // Given
        assertThat(visitDao.findOne(1L)).isNotNull();
        assertThat(visitDao.findOne(4L)).isNotNull();
        assertThat(doctorDao.findOne(1L)).isNotNull();
        assertThat(doctorDao.findOne(2L)).isNotNull();
        assertThat(doctorDao.findOne(3L)).isNotNull();

        // When
        patientService.remove(1L); // Usuwamy pacjenta Adama

        // Then
        assertThat(visitDao.findOne(1L)).isNull(); // Wizyty pacjenta Adama muszą zostać usunięte
        assertThat(visitDao.findOne(4L)).isNull(); // Wizyty pacjenta Adama muszą zostać usunięte
        assertThat(doctorDao.findOne(1L)).isNotNull(); // Lekarze nie powinni zostać usunięci
        assertThat(doctorDao.findOne(2L)).isNotNull(); 
        assertThat(doctorDao.findOne(3L)).isNotNull(); 
    }
}
