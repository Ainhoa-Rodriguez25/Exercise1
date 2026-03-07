package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class SquareService {
    public boolean isSquare(int num1, int num2) {
        return num2 == num1 * num1;
    }
}
