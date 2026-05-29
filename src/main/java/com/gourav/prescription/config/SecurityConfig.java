package com.gourav.prescription.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.gourav.prescription.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;
    public SecurityConfig(CustomUserDetailsService userDetailsService) {
          this.userDetailsService = userDetailsService;
     }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
    }



    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authProvider =
                new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

//        authProvider.setAuthoritiesMapper(authorities -> {
//            return authorities.stream()
//                    .map(a -> new SimpleGrantedAuthority(a.getAuthority()))
//                    .collect(Collectors.toList());
//        });

        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/register", "/login")
                        .permitAll()


                        .requestMatchers("/admin/**")
                        .hasRole("ADMIN")

                        .requestMatchers("/doctor/**")
                        .hasRole("DOCTOR")
                        .requestMatchers("/patient/**")
                        .hasRole("PATIENT")


                        .anyRequest()
                        .authenticated()
                )
                .formLogin(form -> form
                          .loginPage("/login")
                          .usernameParameter("email")

                        .successHandler((request, response, authentication) -> {

                            if(authentication.getAuthorities()
                                    .stream()
                                    .anyMatch(a ->
                                            a.getAuthority()
                                                    .equals("ROLE_ADMIN"))) {

                                response.sendRedirect("/admin/dashboard");

                            }
                            else if(authentication.getAuthorities()
                                    .stream()
                                    .anyMatch(a -> a.getAuthority()
                                                    .equals("ROLE_DOCTOR")))
                            {
                                response.sendRedirect("/doctor/dashboard");

                            }
                            else
                            {

                                response.sendRedirect("/patient/dashboard");
                            }
                        })
                        .permitAll()).logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                         .permitAll());
                return http.build();
    }

}