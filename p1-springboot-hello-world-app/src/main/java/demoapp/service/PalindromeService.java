package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
    public Boolean isPalindrome (String word) {
        // Palindrome: word that reads the same backwards and fowards
        if (word == null) {
            return false;
        }

        String cleaned = word.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(word).reverse().toString();

        return cleaned.equalsIgnoreCase(reversed);
    }
}
