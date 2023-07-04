package com.example.authenticatingldap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class WebSecurityConfig_configure6ecf7d5abdTest {

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @MockBean
    private AuthenticationManagerBuilder authManagerBuilder;

    @Test
    public void testConfigure_success() throws Exception {
        // Mocking the authenticationManager
        AuthenticationProvider provider = mock(AuthenticationProvider.class);
        when(authManagerBuilder.authenticationProvider(provider)).thenReturn(authManagerBuilder);

        // Test the configure method
        webSecurityConfig.configure(authManagerBuilder);

        // Verify the interactions
        verify(authManagerBuilder, times(1)).authenticationProvider(provider);
    }

    @Test
    public void testConfigure_exception() throws Exception {
        // Mocking the authenticationManager to throw an exception
        doThrow(new Exception("Test exception")).when(authManagerBuilder).authenticationProvider(any());

        // Test the configure method
        try {
            webSecurityConfig.configure(authManagerBuilder);
        } catch (Exception e) {
            // Verify the exception
            assertEquals("Test exception", e.getMessage());
        }

        // Verify the interactions
        verify(authManagerBuilder, times(1)).authenticationProvider(any());
    }
}
