insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030');

-- Adresy pacjentów
insert into address (id, address_line1, address_line2, city, postal_code, patient_id)
values (1, 'Main Street', 'Apt 1', 'Springfield', '62-030', 1),
       (2, 'Elm Street', 'Suite 5', 'Shelbyville', '62-040', 2),
       (3, 'Maple Avenue', '', 'Capital City', '62-050', 3);

-- Doktorzy
insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
values (1, 'Jan', 'Nowak', '123123123', 'jan.nowak@domain.com', 'DR001', 'neurolog'),
       (2, 'Maria', 'Wiśniewska', '456456456', 'maria.wisniewska@domain.com', 'DR002', 'kardiolog'),
       (3, 'Tomasz', 'Kowalczyk', '789789789', 'tomasz.kowalczyk@domain.com', 'DR003', 'ortopeda');

-- Pacjenci
insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth)
values (1, 'Adam', 'Kowalski', '987987987', 'adam.kowalski@domain.com', 'PT001', '1995-07-12'),
       (2, 'Ewa', 'Nowak', '654654654', 'ewa.nowak@domain.com', 'PT002', '1988-03-22'),
       (3, 'Robert', 'Wiśniewski', '321321321', 'robert.wisniewski@domain.com', 'PT003', '2001-11-05');

-- Wizyty
insert into visit (id, description, time, patient_id, doctor_id)
values (1, 'Ból głowy', '2024-01-05 12:15:00', 1, 1),
       (2, 'Ból w klatce piersiowej', '2024-01-06 14:30:00', 2, 2),
       (3, 'Zwichnięcie kostki', '2024-01-07 09:45:00', 3, 3),
       (4, 'Migrena', '2024-01-08 11:00:00', 1, 1),
       (5, 'Zawroty głowy', '2024-01-08 16:20:00', 2, 2);

-- Leczenia
insert into medical_treatment (id, description, type, visit_id)
values (1, 'Kuracja podstawowa', 'Normal', 1),
       (2, 'Diagnostyka kardiologiczna', 'Advanced', 2),
       (3, 'Terapia urazowa', 'Normal', 3),
       (4, 'Leczenie przeciwbólowe', 'Normal', 4),
       (5, 'Profilaktyka neurologiczna', 'Preventive', 1),
       (6, 'Rehabilitacja pourazowa', 'Rehabilitation', 3);
