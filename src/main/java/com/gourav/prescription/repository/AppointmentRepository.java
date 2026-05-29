package com.gourav.prescription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gourav.prescription.entity.Appointment;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>
{
    List<Appointment> findByPatientEmail(String patientEmail);

    List<Appointment> findByDoctorName(String doctorName);
}