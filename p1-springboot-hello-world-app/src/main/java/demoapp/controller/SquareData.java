package demoapp.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SquareData {
    @NotNull
    @Min(-1000000)
    @Max(1000000)
    private Integer num1;

    @NotNull
    @Min(-1000000)
    @Max(1000000)
    private Integer num2;

    //Getters
    public Integer getNum1() {
        return num1;
    }

    public Integer getNum2() {
        return num2;
    }

    // Setters
    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }
}
