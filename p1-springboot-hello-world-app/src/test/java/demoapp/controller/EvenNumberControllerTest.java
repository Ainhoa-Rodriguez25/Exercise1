package demoapp.controller;


import demoapp.service.EvenNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EvenNumberController.class)
public class EvenNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EvenNumberService service;

    @Test
    void loadEvenNumberForm() throws Exception {
        mockMvc.perform(get("/even"))
                .andExpect(status().isOk())
                .andExpect(view().name("evenForm"));
    }

    @Test
    void returnResultWhenPostingValidNumber() throws Exception {
        when(service.isEven(4)).thenReturn(true);

        mockMvc.perform(post("/even")
                .param("number", "4"))
                .andExpect(status().isOk())
                .andExpect(view().name("evenResult"))
                .andExpect(model().attributeExists("result"));
    }
}
