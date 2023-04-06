package com.bkryvetskyi.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;


public class DivisionPrinter {
    private static final Logger logger = LogManager.getLogger(DivisionPrinter.class.getName());
    private static final String UNDERLINE = "_";
    private static final String STRAIGHT_SLASH = "|";
    private static final String DASH = "-";

    public void columnDivision(int dividend, int divisior) {

        ArrayList<Integer> dividendDigits = new ArrayList<>();

        int quotient = dividend / divisior;
        int remainder = dividend % divisior;
        int result = 0;

        addNumberDigitsToList(dividendDigits, dividend);

        logger.info("{}{}{}{}", UNDERLINE, StringUtils.leftPad(String.valueOf(dividend),
                String.valueOf(dividend).length(), ' '), STRAIGHT_SLASH, divisior);

        for (int i = 0; i < dividendDigits.size(); i++) {
            for (int j = 1; j < dividendDigits.size() - 1; j++) {
                result = dividendDigits.get(i);
                if (result < divisior) {
                    result = result * 10 + dividendDigits.get(j);
                } else {
                    for (int k = 9; k >= 1; k--) {
                        int multiplicationDigits = k * divisior;
                        if (multiplicationDigits <= result)
                            result -= multiplicationDigits;
                    }
                }
            }
        }
        logger.info("{}{}{}{}", result, StringUtils.leftPad(String.valueOf(dividend),
                        String.valueOf(dividend).length(), StringUtils.SPACE), STRAIGHT_SLASH,
                StringUtils.repeat(StringUtils.SPACE, 5));
        logger.info("{}{}{}", DASH, STRAIGHT_SLASH, quotient);
        logger.info("{}{}", DASH, STRAIGHT_SLASH);
    }

    private ArrayList<Integer> addNumberDigitsToList(ArrayList<Integer> arrayDigitsint, int digits) {

        while (digits > 0) {
            arrayDigitsint.add(digits % 10);
            digits /= 10;
        }
        Collections.reverse(arrayDigitsint);

        return arrayDigitsint;
    }
}
