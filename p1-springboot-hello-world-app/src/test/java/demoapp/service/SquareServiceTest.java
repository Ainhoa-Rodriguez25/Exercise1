package demoapp.service;

import demoapp.service.square.SquareService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SquareServiceTest {
    private SquareService service;

    @BeforeEach
    void setUp() {service = new SquareService();}

    @Test
    void returnTrueWhenNumber2IsSquare() {assertTrue(service.isSquare(3, 9));}

    @Test
    void returnTrueWhenNumber2IsNotSquare() {assertFalse(service.isSquare(3,8));}

    @Test
    void workWithNegativeNumbers() {assertTrue(service.isSquare(-3, 9));}

    @Test
    void workWithZero() { assertTrue(service.isSquare(0, 0));}
}
