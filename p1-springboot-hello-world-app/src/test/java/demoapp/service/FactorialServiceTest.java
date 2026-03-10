package demoapp.service;

import demoapp.service.factorial.FactorialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialServiceTest {
    private FactorialService service;

    @BeforeEach
    void setUp() {service = new FactorialService();}

    @Test
    void returnResulFor5() {
        assertEquals(120L, service.calculateFactorial(5));
    }

    @Test
    void shouldReturn1For0() {
        assertEquals(1L, service.calculateFactorial(0));
    }

    @Test
    void shouldReturn1For1() {
        assertEquals(1L, service.calculateFactorial(1));
    }

    @Test
    void shouldReturnCorrectValueFor20() {
        assertEquals(2432902008176640000L, service.calculateFactorial(20));
    }
}
