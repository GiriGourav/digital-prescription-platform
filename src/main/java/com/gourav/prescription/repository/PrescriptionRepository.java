package com.gourav.prescription.repository;

import com.gourav.prescription.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    List<Prescription>
    findByPatientNameContainingIgnoreCase(String patientName);

    List<Prescription>
    findByPatientEmail(String patientEmail);

    List<Prescription>
    findByDoctorEmail(String doctorEmail);

}