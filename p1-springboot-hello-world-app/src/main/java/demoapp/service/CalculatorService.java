package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculate(int num1, int num2, String operation) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return (double) num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
