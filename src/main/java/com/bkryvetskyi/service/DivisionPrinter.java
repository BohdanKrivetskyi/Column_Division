package com.bkryvetskyi.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class DivisionPrinter {
    private static final Logger logger = LogManager.getLogger(DivisionPrinter.class.getName());
    private static final String UNDERLINE = "_";
    private static final String STRAIGHT_SLASH = "|";
    private static final String DASH = "-";

    // Method to print the division calculation columns.
    public void printColumnDivision(int dividend, int divisior) {

        // Convert the dividend to an ArrayList of its digits.
        ArrayList<Integer> dividendDigitsArray = new ArrayList<>();
        addNumberDigitsToList(dividendDigitsArray, dividend);

        // Calculate quotient and remainder.
        int quotient = dividend / divisior;
        int remainder = dividend % divisior;

        // Initialize digitsDividendIndex with the first digit of the dividend
        int digitsDividendIndex = dividendDigitsArray.get(0);

        // Calculate the optimal divisor for subtraction and store the result in digitsDividend
        int digitsDividend =
                calculateOptimalDivisorForSubtraction(dividendDigitsArray, divisior, digitsDividendIndex);
        // Find the digits for multiplication and store the result in multiplication.
        int multiplication = findDigitsForMultiplication(digitsDividend, divisior);
        // Calculate the difference between digitsDividend
        // and multiplication and store the result in difference.
        int difference = digitsDividend - multiplication;


        // Print the division calculation columns.
        logger.info("{}{}{}{}", UNDERLINE, StringUtils.leftPad(String.valueOf(dividend),
                dividendDigitsArray.size()), STRAIGHT_SLASH, divisior);

        logger.info("{}{}{}{}",
                " ", multiplication, StringUtils.leftPad(STRAIGHT_SLASH,
                        dividendDigitsArray.size() - String.valueOf(multiplication).length() + 1),
                StringUtils.repeat(DASH, String.valueOf(quotient).length()));

        logger.info("{}{}{}{}",
                " ", StringUtils.repeat(DASH, String.valueOf(multiplication).length()),
                StringUtils.leftPad(STRAIGHT_SLASH,
                        dividendDigitsArray.size() - String.valueOf(multiplication).length() + 1), quotient);

        logger.info("{}{}{}", UNDERLINE, difference);
    }

    // Method to convert a number's digits into an ArrayList.
    private ArrayList<Integer> addNumberDigitsToList(ArrayList<Integer> arrayDigitsInt, int digits) {

        // Extract the digits from the number and add them to the ArrayList
        while (digits > 0) {
            arrayDigitsInt.add(digits % 10);
            digits /= 10;
        }
        // Reverse the order of the digits in the ArrayList.
        Collections.reverse(arrayDigitsInt);

        return arrayDigitsInt;
    }

    // Method to calculate the optimal divisor for subtraction.
    private int calculateOptimalDivisorForSubtraction(ArrayList<Integer> dividendDigitsArray,
                                                      int divisior,
                                                      int digitDividend) {
        // Set digitDividend to the first digit of the dividend.
        Iterator<Integer> iterator = dividendDigitsArray.listIterator(digitDividend);
        // Use an iterator to calculate the optimal divisor for subtraction.
        while (iterator.hasNext() && digitDividend < divisior) {
            digitDividend = digitDividend * 10 + iterator.next();
        }

        return digitDividend;
    }

    // Method to find the digits for multiplication.
    private int findDigitsForMultiplication(int digitDivident, int divisior) {

        int multiplication = 0;
        // Find the largest multiple of the divisor that is less than or equal to the digitsDividend
        for (int k = 9; k > 0; k--) {
            multiplication = divisior * k;
            if (digitDivident >= multiplication) break;
        }

        return multiplication;
    }
}
