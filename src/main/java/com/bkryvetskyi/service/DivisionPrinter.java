package com.bkryvetskyi.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class DivisionPrinter {


    // Method to calculate the optimal divisor for subtraction.
    public List<Integer> calculateOptimalDivisorForSubtraction(String dividend, int divisior) {

        // Start with the first digit of the dividend.
        int digitResult = Character.getNumericValue(dividend.charAt(0));
        // Variable to store the result of multiplication.
        int multiplication;

        // Create a list to store the results.
        List<Integer> result = new ArrayList<>();

        // Loop through the dividend, starting from the second digit.
        for (int i = 1; i < dividend.length(); ) {

            // If the current digit result is less than the divisor,
            // add the next digit and continue to the next iteration.
            if (digitResult < divisior) {
                digitResult = digitResult * 10 + Character.getNumericValue(dividend.charAt(i));
                i++;

                // If the digit result is now greater than the divisor,
                // add it to the results list.
                if (digitResult > divisior) {
                    result.add(digitResult);
                }
            } else {
                // If the current digit result is greater than or equal to the divisor,
                // find the digits for multiplication, add it to the results list,
                // and subtract the result from the current digit.
                multiplication = findDigitsForMultiplication(digitResult, divisior);
                result.add(multiplication);
                digitResult -= multiplication;
            }
        }
        // If the final digit result is less than the divisor,
        // return the results list.
        if (digitResult < divisior) {
            return result;
        } else {
            // If the final digit result is greater than or equal to the divisor,
            // find the digits for multiplication, add it to the results list,
            // subtract the result from the current digit, and add the final digit
            // result to the results list.
            multiplication = findDigitsForMultiplication(digitResult, divisior);
            result.add(multiplication);
            digitResult = digitResult - multiplication;
            result.add(digitResult);
        }
        return result;
    }

    // Method to find the digits for multiplication.
    public int findDigitsForMultiplication(int digitDividend, int divisior) {

        int multiplication = 0;
        // Find the largest multiple of the divisor that is less than or equal to the digitsDividend
        for (int k = 9; k > 0; k--) {
            multiplication = divisior * k;
            if (digitDividend >= multiplication) break;
        }

        // Return the final results list.
        return multiplication;
    }
}
