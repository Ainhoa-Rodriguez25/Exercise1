package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
    public Boolean isPalindrome (String word) {
        // Palindrome: word that reads the same backwards and fowards
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equalsIgnoreCase(reversed);
    }
}
