package demoapp.service;

import demoapp.service.evennumber.EvenNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvenNumberServiceTest {
    private EvenNumberService service;

    @BeforeEach
    void setUp() {service = new EvenNumberService();}

    @Test
    void returnTrueWhenNumberisEven() {assertTrue(service.isEven(4));}

    @Test
    void returnFalseWhenNumberIsOdd() {assertFalse(service.isEven(7));}

    @Test
    void workWithNegativeNumbers() {assertTrue(service.isEven(-2));}
}
