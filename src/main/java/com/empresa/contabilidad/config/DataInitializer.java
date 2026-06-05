package com.empresa.contabilidad.config;

import com.empresa.contabilidad.entity.Role;
import com.empresa.contabilidad.entity.Usuario;
import com.empresa.contabilidad.repository.RoleRepository;
import com.empresa.contabilidad.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_ADMIN").build()));
            Role userRole = roleRepository.findByName("ROLE_USER").orElseGet(() -> roleRepository.save(Role.builder().name("ROLE_USER").build()));

            if (usuarioRepository.findByUsername("admin").isEmpty()) {
                Usuario admin = Usuario.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("password"))
                        .enabled(true)
                        .roles(Set.of(adminRole, userRole))
                        .build();
                usuarioRepository.save(admin);
            }
        };
    }
}
