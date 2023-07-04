package com.example.authenticatingldap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthenticatingLdapApplication_mainf5686752dfTest {

    @Test
    public void testMain_Success() {
        String[] args = new String[]{"arg1", "arg2"};
        AuthenticatingLdapApplication.main(args);
    }

    @Test
    public void testMain_EmptyArgs() {
        String[] args = new String[]{};
        AuthenticatingLdapApplication.main(args);
    }
}
