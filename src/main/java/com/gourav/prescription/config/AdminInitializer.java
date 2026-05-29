package com.gourav.prescription.config;

import com.gourav.prescription.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.context.annotation.Bean;
import com.gourav.prescription.repository.UserRepository;

@Configuration
public class AdminInitializer
{

    @Bean
    CommandLineRunner init(UserRepository userRepository, BCryptPasswordEncoder encoder)
    {

        return args -> {


            if(userRepository.findByEmail("admin@gmail.com") == null)
            {
                User admin = new User();
                admin.setName("Admin");
                admin.setEmail("admin@gmail.com");
                admin.setPassword(encoder.encode("admin123"));


                admin.setRole("ADMIN");
                admin.setApproved(true);
                userRepository.save(admin);

                System.out.println("Admin Created!");
            }
        };

    }
}