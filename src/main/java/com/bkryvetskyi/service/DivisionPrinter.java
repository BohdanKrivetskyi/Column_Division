package com.bkryvetskyi.service;

import java.util.ArrayList;
import java.util.Collections;


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
}
