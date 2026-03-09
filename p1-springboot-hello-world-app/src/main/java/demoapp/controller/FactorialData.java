package demoapp.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class FactorialData {
    @NotNull(message = "Number is required")
    @Min(value = 0, message = "Number must be at least 0")
    @Max(value = 20, message = "Number must be 20 or less (long overflow limit)") // 21! exceeds the capacity of long
    private Integer number;

    // Getters
    public Integer getNumber() {
        return number;
    }

    // Setters
    public void setNumber(Integer number) {
        this.number = number;
    }
}
