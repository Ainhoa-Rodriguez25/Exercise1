package demoapp.controller.palindrome;

import demoapp.service.palindrome.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PalindromeController {

    @Autowired
    private PalindromeService service;

    @GetMapping("/palindrome")
    public String showForm(Model model) {
        model.addAttribute("palindromeData", new PalindromeData());
        return "palindrome/palindromeForm";
    }

    @PostMapping("/palindrome")
    public String checkPalindrome(@Valid PalindromeData palindromeData, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "palindrome/palindromeForm";
        }

        boolean isPalindrome = service.isPalindrome(palindromeData.getWord());
        model.addAttribute("result", isPalindrome);

        return "palindrome/palindromeResult";
    }
}
