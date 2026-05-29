package com.gourav.prescription.controller;

import org.openpdf.text.Document;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.security.core.Authentication;
import com.gourav.prescription.entity.Prescription;
import com.gourav.prescription.repository.PrescriptionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import java.security.Principal;
import com.gourav.prescription.entity.User;
import com.gourav.prescription.repository.UserRepository;

@Controller
public class PrescriptionController
{
    private final PrescriptionRepository prescriptionRepository;

    private final UserRepository userRepository;

    public PrescriptionController(PrescriptionRepository prescriptionRepository,
            UserRepository userRepository) {

        this.prescriptionRepository = prescriptionRepository;
        this.userRepository = userRepository;
    }
    @GetMapping("/doctor/prescription/create")
    public String createPrescription(Model model)
    {
        model.addAttribute("prescription", new Prescription());
        return "create-prescription";
    }
    @PostMapping("/doctor/prescription/save")
    public String savePrescription(
            @ModelAttribute Prescription prescription,
            Principal principal)
    {

        User doctor = userRepository.findByEmail(principal.getName());

        prescription.setDoctorName(doctor.getName());

        prescription.setDoctorEmail(doctor.getEmail());

        prescription.setDate(LocalDate.now());
        prescriptionRepository.save(prescription);
        return "redirect:/doctor/dashboard";
    }
    @GetMapping("/prescription/pdf/{id}")
    public void downloadPdf(@PathVariable Long id,
            HttpServletResponse response) throws Exception {
        Prescription prescription = prescriptionRepository.findById(id).orElseThrow();
        response.setContentType("application/pdf");


        response.setHeader("Content-Disposition", "attachment;filename=prescription.pdf");
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());


        document.open();
        document.add(new Paragraph("Doctor: "+ prescription.getDoctorName()));
        document.add(new Paragraph("Patient: " + prescription.getPatientName()));
         document.add(new Paragraph("Diagnosis: " + prescription.getDiagnosis()));

        document.add(new Paragraph("Medicines: "+prescription.getMedicines()));
        document.add(new Paragraph("Date: " + prescription.getDate()));
        document.close();
    }

    @GetMapping("/patient/search")
    public String searchPrescription(@RequestParam String patientName, Model model)
    {
        model.addAttribute("prescriptions", prescriptionRepository
                        .findByPatientNameContainingIgnoreCase(patientName));

        return "view-prescriptions";
    }

    @GetMapping("/doctor/prescription/edit/{id}")
    public String editPrescription(@PathVariable Long id, Model model)
    {

        Prescription prescription =
                prescriptionRepository.findById(id)
                        .orElseThrow();

        model.addAttribute("prescription", prescription);

        return "edit-prescription";
    }

    @PostMapping("/doctor/prescription/update")
    public String updatePrescription(@ModelAttribute Prescription prescription)
    {
        prescriptionRepository.save(prescription);
        return "redirect:/doctor/prescriptions";
    }

    @GetMapping("/doctor/prescription/delete/{id}")
    public String deletePrescription(@PathVariable Long id)
    {
        prescriptionRepository.deleteById(id);

        return "redirect:/doctor/prescriptions";
    }
    @GetMapping("/patient/prescriptions")
    public String viewPrescriptions(Authentication authentication, Model model)
    {

        String email = authentication.getName();
        model.addAttribute("prescriptions", prescriptionRepository.findByPatientEmail(email));
        return "view-prescriptions";
    }

    @GetMapping("/doctor/prescriptions")
    public String doctorPrescriptions(Model model, Principal principal)
    {

        model.addAttribute("prescriptions",
                prescriptionRepository.findAll());
//                        .findByDoctorEmail(principal.getName()));
        return "doctor-prescriptions";
    }


    @GetMapping("/doctor/prescriptions/search")
    public String searchPrescriptionByPatient(@RequestParam String patientName, Model model)
    {

        model.addAttribute("prescriptions",
                prescriptionRepository
                        .findByPatientNameContainingIgnoreCase(patientName));

        return "doctor-prescriptions";
    }

}
