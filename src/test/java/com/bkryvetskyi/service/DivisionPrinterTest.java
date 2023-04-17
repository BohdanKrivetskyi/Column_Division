package com.bkryvetskyi.service;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivisionPrinterTest {
    @Test
    void PrintColumnDivision() {
        DivisionPrinter divisionPrinter = new DivisionPrinter();
        divisionPrinter.printColumnDivision("48945", 4);

      /*  _48945|4
           4       |-----
           -      |12236
           _8
            8
            -
             _9
              8
              -
             _14
              12
              --
              _25
               24
               --
               1*/
        assertEquals(0, 0); // placeholder assertion
    }

    @Test
    void CalculateOptimalDivisorForSubtraction() {
        DivisionPrinter divisionPrinter = new DivisionPrinter();
        List<Integer> result = divisionPrinter.calculateOptimalDivisorForSubtraction("123456", 12);
        List<Integer> expected = Arrays.asList(12, 34, 24, 105, 96, 96, 96, 0);
        assertEquals(expected, result);
    }

    @Test
    void FindDigitsForMultiplication() {
        DivisionPrinter divisionPrinter = new DivisionPrinter();
        int result = divisionPrinter.findDigitsForMultiplication(48, 5);
        assertEquals(45, result);
    }

}