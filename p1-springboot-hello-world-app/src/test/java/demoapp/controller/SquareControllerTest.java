package demoapp.controller;

import demoapp.controller.square.SquareController;
import demoapp.service.square.SquareService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SquareController.class)
public class SquareControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SquareService service;

    @Test
    void loadSquareForm() throws Exception {
        mockMvc.perform(get("/square"))
                .andExpect(status().isOk())
                .andExpect(view().name("square/squareForm"));
    }

    @Test
    void returnResultWhenSquareIsValid() throws Exception {
        when(service.isSquare(3, 9)).thenReturn(true);

        mockMvc.perform(post("/square")
                        .param("num1", "3")
                        .param("num2", "9"))
                .andExpect(status().isOk())
                .andExpect(view().name("square/squareResult"))
                .andExpect(model().attributeExists("result"));
    }

    @Test
    void returnResultWhenSquareIsNotValid() throws Exception {
        when(service.isSquare(3, 8)).thenReturn(true);

        mockMvc.perform(post("/square")
                        .param("num1", "3")
                        .param("num2", "8"))
                .andExpect(status().isOk())
                .andExpect(view().name("square/squareResult"))
                .andExpect(model().attributeExists("result"));
    }
}
