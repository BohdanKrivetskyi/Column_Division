package com.bkryvetskyi.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class DivisionPrinter {

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
}
