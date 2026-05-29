package com.gourav.prescription.controller;
import org.springframework.stereotype.Controller;

import com.gourav.prescription.entity.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.gourav.prescription.repository.UserRepository;

@Controller
public class AdminController {

    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model)
    {

        model.addAttribute("pendingDoctors",
                userRepository.findByRoleAndApproved("DOCTOR", false).size());

        model.addAttribute("approvedDoctors",
                userRepository.findByRoleAndApproved("DOCTOR", true).size());

        return "admin-dashboard";
    }
    @GetMapping("/admin/doctors")
    public String manageDoctors(Model model){

        model.addAttribute(
                "doctors",
                userRepository.findByRole("DOCTOR")
        );

        return "manage-doctors";
    }

    @GetMapping("/admin/doctor/approve/{id}")
    public String approveDoctor(@PathVariable Long id)
    {
        User doctor = userRepository.findById(id).orElseThrow();

        doctor.setApproved(true);
        userRepository.save(doctor);

        return "redirect:/admin/doctors";
    }
    @GetMapping("/admin/doctor/delete/{id}")
    public String deleteDoctor(@PathVariable Long id)
    {

        userRepository.deleteById(id);
        return "redirect:/admin/doctors";
    }
}