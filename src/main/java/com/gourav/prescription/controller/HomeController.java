package com.gourav.prescription.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{

    @GetMapping("/")
    public String home()
    {
         return "index";
    }



    @GetMapping("/doctor/dashboard")
    public String doctorDashboard()
    {
         return "doctor-dashboard";
    }


    @GetMapping("/patient/dashboard")
    public String patientDashboard()
    {
         return "patient-dashboard";
    }
}