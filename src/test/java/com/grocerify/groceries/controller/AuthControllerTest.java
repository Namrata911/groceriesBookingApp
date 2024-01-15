package com.grocerify.groceries.controller;

import com.grocerify.groceries.model.Role;
import com.grocerify.groceries.model.RoleEnum;
import com.grocerify.groceries.model.User;
import com.grocerify.groceries.repository.RoleRepository;
import com.grocerify.groceries.repository.UserRepository;
import com.grocerify.groceries.security.jwt.JwtUtils;
import com.grocerify.groceries.security.payload.request.LoginRequest;
import com.grocerify.groceries.security.payload.request.SignupRequest;
import com.grocerify.groceries.security.payload.response.JwtResponse;
import com.grocerify.groceries.security.payload.response.MessageResponse;
import com.grocerify.groceries.security.service.UserDetailsImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder encoder;

    @Mock
    private JwtUtils jwtUtils;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() {
        HashSet<String> roles = new HashSet<>(Collections.singletonList("user"));
        SignupRequest signupRequest = new SignupRequest("username", "email",  roles,"password");
        Role userRole = new Role();
        userRole.setName(RoleEnum.ROLE_USER);
        when(userRepository.existsByUsername("username")).thenReturn(false);
        when(userRepository.existsByEmail("email")).thenReturn(false);
        when(roleRepository.findByName(RoleEnum.ROLE_USER)).thenReturn(java.util.Optional.of(userRole));
        when(encoder.encode("password")).thenReturn("encodedPassword");

        ResponseEntity<?> response = authController.registerUser(signupRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MessageResponse.class, response.getBody().getClass());
        verify(userRepository, times(1)).save(any(User.class));
    }
}
