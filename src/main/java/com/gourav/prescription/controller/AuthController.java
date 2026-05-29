package com.gourav.prescription.controller;

import com.gourav.prescription.repository.UserRepository;

import com.gourav.prescription.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registerPage(Model model)
    {
        model.addAttribute("user", new User());
        return "register";

    }



    @GetMapping("/login")
    public String loginPage()
    {
        return "login";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user)
    {
        user.setPassword(
                passwordEncoder.encode(
                        user.getPassword()
                )
        );

        if(user.getRole().equals("DOCTOR")) {

            user.setApproved(false);

        } else {

            user.setApproved(true);
        }
        userRepository.save(user);
        return "redirect:/login";
    }
}
