package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class FactorialService {
    public long calculateFactorial(int number) {
        // Number validation
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }

        long result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}
