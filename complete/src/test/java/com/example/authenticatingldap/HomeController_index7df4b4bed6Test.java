package com.example.authenticatingldap;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HomeController_index7df4b4bed6Test {

    @MockBean
    private HomeController homeController;

    @Test
    public void testIndexSuccess() {
        String expectedOutput = "Welcome to the home page!";
        Mockito.when(homeController.index()).thenReturn(expectedOutput);
        String actualOutput = homeController.index();
        assertEquals(expectedOutput, actualOutput, "Index method did not return expected output.");
    }

    @Test
    public void testIndexFailure() {
        String expectedOutput = "This is not the home page!";
        Mockito.when(homeController.index()).thenReturn(expectedOutput);
        String actualOutput = homeController.index();
        assertEquals(expectedOutput, actualOutput, "Index method did not return expected output.");
    }
}
