package demoapp.controller.palindrome;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PalindromeData {
    @Valid
    @NotBlank // It's used to check that a char sequence is not null and that its length is greater than 0
    @Size(min = 1, max = 30)
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
