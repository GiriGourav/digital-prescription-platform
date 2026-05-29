package com.gourav.prescription.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patientName;
    private String patientEmail;
    private String doctorName;
    private LocalDate appointmentDate;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

}