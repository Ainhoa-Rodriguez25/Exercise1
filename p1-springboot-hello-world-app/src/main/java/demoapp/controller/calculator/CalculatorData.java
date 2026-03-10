package demoapp.controller.calculator;

import javax.validation.constraints.*;

public class CalculatorData {
    @NotNull
    @Min(-1000000)
    @Max(1000000)
    private Integer num1;

    @NotNull // (Se debe indicar para cada variable)
    @Min(-1000000)
    @Max(1000000)
    private Integer num2;

    //Introducción de variable operacion para almacenar el tipo
    @NotBlank
    @Pattern(regexp = "[+\\-*/]", message = "Operation must be +, -, * or /") // Con esto se comprueba que la operación introducida está dentro de las opciones establecidas
    private String operation;


    //Getters
    public Integer getNum1() { return num1; }

    public Integer getNum2() { return num2; }

    public String getOperation() {
        return operation;
    }


    //Setters
    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public void setNum2(Integer num2) {
        this.num2 = num2;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
