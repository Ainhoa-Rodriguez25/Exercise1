package demoapp.controller;

import demoapp.service.FactorialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FactorialController.class)
public class FactorialControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FactorialService service;

    @Test
    void loadFactorialForm() throws Exception {
        mockMvc.perform(get("/factorial"))
                .andExpect(status().isOk())
                .andExpect(view().name("factorialForm"));
    }

    @Test
    void returnResultWhenInputIsValid() throws Exception {

        when(service.calculateFactorial(5)).thenReturn(120L);

        mockMvc.perform(post("/factorial")
                        .param("number", "5"))
                .andExpect(status().isOk())
                .andExpect(view().name("factorialResult"))
                .andExpect(model().attributeExists("result"));
    }

    @Test
    void returnFormWhenInputIsInvalid() throws Exception {

        mockMvc.perform(post("/factorial")
                        .param("number", "-1"))   // inválido por @Min(0)
                .andExpect(status().isOk())
                .andExpect(view().name("factorialForm"));
    }
}
