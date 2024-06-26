package org.example.book_my_show.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BcryptPasswordEncoderConfig {
    @Bean
    public BCryptPasswordEncoder  getBcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
