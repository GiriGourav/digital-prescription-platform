package com.gourav.prescription.controller;

import com.gourav.prescription.entity.Appointment;
import com.gourav.prescription.entity.User;
import com.gourav.prescription.repository.AppointmentRepository;
import com.gourav.prescription.repository.UserRepository;
import com.gourav.prescription.entity.AppointmentStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final UserRepository userRepository;

    public AppointmentController(AppointmentRepository appointmentRepository, UserRepository userRepository)
    {

        this.appointmentRepository = appointmentRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/patient/appointment/book")
    public String appointmentForm(Model model)
    {
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("doctors",
                userRepository.findByRole("DOCTOR")
        );
        return "book-appointment";
    }

    @PostMapping("/patient/appointment/save")
    public String saveAppointment(@ModelAttribute Appointment appointment)
    {
        appointment.setStatus(AppointmentStatus.PENDING);
        appointmentRepository.save(appointment);
        return "redirect:/patient/dashboard";
    }


    @GetMapping("/patient/appointments")
    public String patientAppointments(Authentication authentication, Model model)
    {
        model.addAttribute("appointments",
                appointmentRepository.findByPatientEmail(authentication.getName()));
        return "patient-appointments";
    }



    @GetMapping("/doctor/appointments")
    public String doctorAppointments(Authentication authentication,Model model)
    {
        model.addAttribute("appointments",
                appointmentRepository.findByDoctorName(authentication.getName())
        );
        return "doctor-appointments";
    }




    @GetMapping("/doctor/appointment/approve/{id}")
    public String approveAppointment(@PathVariable Long id)
    {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        appointment.setStatus(AppointmentStatus.APPROVED);
        appointmentRepository.save(appointment);
        return "redirect:/doctor/appointments";
    }



    @GetMapping("/doctor/appointment/reject/{id}")
    public String rejectAppointment(@PathVariable Long id)
    {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow();
        appointment.setStatus(AppointmentStatus.REJECTED);
        appointmentRepository.save(appointment);
        return "redirect:/doctor/appointments";
    }
}