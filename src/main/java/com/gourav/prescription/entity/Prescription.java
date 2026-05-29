package com.gourav.prescription.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String doctorName;
    private String doctorEmail;
    private String patientName;
    private String patientEmail;
    private String diagnosis;
    private String medicines;
    private String notes;
    private LocalDate date;
}
