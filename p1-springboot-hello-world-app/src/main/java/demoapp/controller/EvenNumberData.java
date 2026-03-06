package demoapp.controller;

import javax.validation.constraints.NotNull;

public class EvenNumberData {
    @NotNull
    private Integer number;

    // Getter
    public Integer getNumber() {
        return number;
    }

    //Setter
    public void setNumber(Integer number) {
        this.number = number;
    }
}
