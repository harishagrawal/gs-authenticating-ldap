package com.example.authenticatingldap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.util.ReflectionTestUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WebSecurityConfig_securityFilterChain59053c8af3Test {

    @InjectMocks
    private WebSecurityConfig webSecurityConfig;

    @Mock
    private HttpSecurity httpSecurity;

    @Mock
    private SecurityFilterChain securityFilterChain;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSecurityFilterChain_success() throws Exception {
        when(httpSecurity.authorizeRequests()).thenReturn(httpSecurity.authorizeRequests());
        when(httpSecurity.formLogin()).thenReturn(httpSecurity.formLogin());
        when(httpSecurity.build()).thenReturn(securityFilterChain);

        SecurityFilterChain result = webSecurityConfig.securityFilterChain(httpSecurity);

        verify(httpSecurity, times(1)).authorizeRequests();
        verify(httpSecurity, times(1)).formLogin();
        verify(httpSecurity, times(1)).build();

        assertEquals(securityFilterChain, result);
    }

    @Test
    void testSecurityFilterChain_exception() throws Exception {
        when(httpSecurity.authorizeRequests()).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> webSecurityConfig.securityFilterChain(httpSecurity));

        verify(httpSecurity, times(1)).authorizeRequests();
        verify(httpSecurity, never()).formLogin();
        verify(httpSecurity, never()).build();
    }
}
