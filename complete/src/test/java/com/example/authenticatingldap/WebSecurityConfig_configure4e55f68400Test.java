package com.example.authenticatingldap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class WebSecurityConfig_configure4e55f68400Test {

    @InjectMocks
    private WebSecurityConfig webSecurityConfig;

    @Mock
    private HttpSecurity httpSecurity;

    @Mock
    private AuthenticationManagerBuilder auth;

    @Test
    public void testConfigure_Success() throws Exception {
        when(httpSecurity.authorizeRequests()).thenReturn(null);
        when(httpSecurity.formLogin()).thenReturn(null);
        webSecurityConfig.configure(auth);
        verify(httpSecurity, times(1)).authorizeRequests();
        verify(httpSecurity, times(1)).formLogin();
    }

    @Test
    public void testConfigure_Exception() throws Exception {
        when(httpSecurity.authorizeRequests()).thenThrow(new RuntimeException());
        assertThrows(Exception.class, () -> webSecurityConfig.configure(auth));
        verify(httpSecurity, times(1)).authorizeRequests();
    }
}
