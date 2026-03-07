package demoapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {
    private CalculatorService service;

    @BeforeEach
    void setUp() {service = new CalculatorService();}

    @Test
    void addNumbers() {
        assertEquals(8.0, service.calculate(5, 3, "+"));
    }

    @Test
    void subtractNumbers() {
        assertEquals(2.0, service.calculate(5, 3, "-"));
    }

    @Test
    void multiplyNumbers() {
        assertEquals(15.0, service.calculate(5, 3, "*"));
    }

    @Test
    void divideNumbers() {
        assertEquals(2.5, service.calculate(5, 2, "/"));
    }

    @Test
    void shouldThrowExceptionWhenDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> service.calculate(5, 0, "/"));
    }

    @Test
    void shouldThrowExceptionWhenInvalidOperation() {
        assertThrows(IllegalArgumentException.class, () -> service.calculate(5, 3, "%"));
    }
}
