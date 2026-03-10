package demoapp.service.palindrome;

import org.springframework.stereotype.Service;

@Service
public class PalindromeService {
    public boolean isPalindrome (String word) {
        // Palindrome: word that reads the same backwards and fowards
        if (word == null) {
            return false;
        }

        String cleaned = word.replaceAll("\\s+", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();

        return cleaned.equals(reversed);
    }
}
