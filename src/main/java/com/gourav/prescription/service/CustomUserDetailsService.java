package com.gourav.prescription.service;

import org.springframework.stereotype.Service;

import com.gourav.prescription.entity.User;
import com.gourav.prescription.repository.UserRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
@Service
public class CustomUserDetailsService implements  UserDetailsService
{
    private final UserRepository userRepository;
    public CustomUserDetailsService(UserRepository userRepository)
    {
          this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException
    {
        User user = userRepository.findByEmail(email);

        if (user == null)
        {
            throw new UsernameNotFoundException("User not found");
        }

        System.out.println("EMAIL = " + user.getEmail());
        System.out.println("ROLE = " + user.getRole());
        System.out.println("APPROVED = " + user.isApproved());

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(Collections.singleton(new SimpleGrantedAuthority(
                                        "ROLE_" + user.getRole())))
                .disabled(user.getRole().equals("DOCTOR")&& !user.isApproved())
                .build();
    }
}
