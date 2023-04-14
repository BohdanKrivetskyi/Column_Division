package com.bkryvetskyi.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class DivisionPrinter {
    private static final Logger logger = LogManager.getLogger(DivisionPrinter.class.getName());
    private static final String UNDERLINE = "_";
    private static final String STRAIGHT_SLASH = "|";
    private static final String DASH = "-";

    // Method to print the division calculation columns.
    public void printColumnDivision(String dividend, int divisior) {
        List<Integer> result = calculateOptimalDivisorForSubtraction(dividend, divisior);
        int size = result.size();

        // Remove the first element if the size of the list is odd.
        if (size % 2 != 0) {
            result.remove(0);
        }

        int multiplication = result.get(0);
        // Calculate quotient and remainder.
        int quotient = Integer.parseInt(dividend) / divisior;
        int remainder = Integer.parseInt(dividend) % divisior;

        // Print the first row.
        logger.info("{}{}{}{}", UNDERLINE, StringUtils.leftPad(dividend,
                dividend.length()), STRAIGHT_SLASH, divisior);

        // Print the second row.
        logger.info("{}{}{}{}",
                StringUtils.SPACE, multiplication, StringUtils.leftPad(STRAIGHT_SLASH,
                        dividend.length() - String.valueOf(multiplication).length() + 1),
                StringUtils.repeat(DASH, String.valueOf(quotient).length()));

        // Print the third row.
        logger.info("{}{}{}{}",
                " ", StringUtils.repeat(DASH, String.valueOf(multiplication).length()),
                StringUtils.leftPad(STRAIGHT_SLASH,
                        dividend.length() - String.valueOf(multiplication).length() + 1), quotient);

        // Print the subsequent rows.
        for (int i = 1, j = 0; i < result.size() - 1; i++) {
            if (result.get(i).equals(result.get(i + 1))) {
                // Print if the elements are the same.
                logger.info("{}{}{}", StringUtils.repeat(" ", String.valueOf(multiplication).length() + j++), UNDERLINE, result.get(i));
                logger.info("{}{}", StringUtils.repeat(" ", String.valueOf(multiplication).length() + j), result.get(++i));
                logger.info("{}{}", StringUtils.repeat(" ", String.valueOf(multiplication).length() + j), StringUtils.repeat(DASH, String.valueOf(result.get(i)).length()));
                j++;
            } else {
                // Print if the elements are not the same.
                logger.info("{}{}{}", StringUtils.repeat(" ", String.valueOf(multiplication).length() - 1 + j), UNDERLINE, result.get(i));
                logger.info("{}{}", StringUtils.repeat(" ", String.valueOf(multiplication).length() + j), result.get(++i));
                logger.info("{}{}", StringUtils.repeat(" ", String.valueOf(multiplication).length() + j), StringUtils.repeat(DASH, String.valueOf(result.get(i)).length()));
                j++;
            }
        }
        // Print the remainder.
        logger.info("{}{}", StringUtils.leftPad("", dividend.length()), remainder);
    }


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
