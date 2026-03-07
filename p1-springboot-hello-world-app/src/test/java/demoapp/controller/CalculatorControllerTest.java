package demoapp.controller;

import demoapp.service.CalculatorService;
import demoapp.service.EvenNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService service;

    @Test
    void loadCalculatorForm() throws Exception {
        mockMvc.perform(get("/calculator"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculatorForm"));
    }

    @Test
    void returnResultWhenCalculationIsValid() throws Exception {
        when(service.calculate(4, 3, "*")).thenReturn(12.0);

        mockMvc.perform(post("/calculator")
                        .param("num1", "4")
                        .param("num2", "3")
                        .param("operation", "*"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculatorResult"))
                .andExpect(model().attributeExists("result"));
    }

    @Test
    void returnFormWhenDivisionByZero() throws Exception {

        doThrow(new IllegalArgumentException("Cannot divide by zero")).when(service).calculate(5, 0, "/");

        mockMvc.perform(post("/calculator")
                        .param("num1", "5")
                        .param("num2", "0")
                        .param("operation", "/"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculatorForm"))
                .andExpect(model().attributeExists("error"));
    }
}
