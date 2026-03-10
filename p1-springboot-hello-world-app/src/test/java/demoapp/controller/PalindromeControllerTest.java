package demoapp.controller;

import demoapp.controller.palindrome.PalindromeController;
import demoapp.service.palindrome.PalindromeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PalindromeController.class)
public class PalindromeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PalindromeService service;

    @Test
    void loadPalindromeForm() throws Exception {
        mockMvc.perform(get("/palindrome"))
                .andExpect(status().isOk())
                .andExpect(view().name("palindrome/palindromeForm"));
    }

    @Test
    void returnResultWhenPostingValidWord() throws Exception {
        when(service.isPalindrome("radar")).thenReturn(true);

        mockMvc.perform(post("/palindrome")
                .param("word", "radar"))
                .andExpect(status().isOk())
                .andExpect(view().name("palindrome/palindromeResult"))
                .andExpect(model().attributeExists("result"));
    }
}
