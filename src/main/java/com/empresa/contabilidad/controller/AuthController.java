package com.empresa.contabilidad.controller;

import com.empresa.contabilidad.dto.AuthenticationRequest;
import com.empresa.contabilidad.dto.AuthenticationResponse;
import com.empresa.contabilidad.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")//permite solicitudes desde el frontend de Angular que se ejecuta en localhost:4200, evitando problemas de CORS al realizar peticiones al backend.
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authReq) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword())//autentica con el servicio de autenticación de Spring Security utilizando el nombre de usuario y la contraseña proporcionados en la solicitud. Si la autenticación es exitosa, se genera un token JWT para el usuario autenticado.
            );
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).build();
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
