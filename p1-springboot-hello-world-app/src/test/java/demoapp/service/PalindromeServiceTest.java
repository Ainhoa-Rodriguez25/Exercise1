package demoapp.service;

import demoapp.service.palindrome.PalindromeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeServiceTest {

    private PalindromeService service;

    @BeforeEach
    void setUp() {
        service = new PalindromeService();
    }

    // Check that the word is a palindrome
    @Test
    void returnTrueWhenWordIsPalindrome() {
        assertTrue(service.isPalindrome("radar"));
    }

    // Test to check if the word is not a palindrome
    @Test
    void returnFalseWhenWordIsNotPalindrome() {
        assertFalse(service.isPalindrome("hello"));
    }

    // Test to verify that the programe ignores spaces
    @Test
    void ignoreSpacesAndCase() {
        assertTrue(service.isPalindrome("Anita lava la tina"));
    }

    // Test that should return false if the word is null
    @Test
    void returnFalseWhenWordIsNull() {
        assertFalse(service.isPalindrome(null));
    }
}
