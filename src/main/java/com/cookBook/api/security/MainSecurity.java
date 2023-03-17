package com.cookBook.api.security;
// package com.example.demo.model.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// import static org.springframework.security.config.Customizer.withDefaults;

/**
 * MainSecurity
 */
// @Configuration
// @EnableWebSecurity
// public class MainSecurity {

//     @Bean
//     PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
    
    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    //     http.authorizeHttpRequests(requests -> requests
    //             .anyRequest()
    //             .authenticated())
    //             .httpBasic(withDefaults());
    //     return http.build();
    // }
    // @Bean
    
    // public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
    //     UserDetails user = User.withUsername("user")
    //         .password(passwordEncoder.encode("password"))
    //         .roles("USER")
    //         .build();

    //     UserDetails admin = User.withUsername("admin")
    //         .password(passwordEncoder.encode("admin"))
    //         .roles("USER", "ADMIN")
    //         .build();

    //     return new InMemoryUserDetailsManager(user, admin);
    // }
// }