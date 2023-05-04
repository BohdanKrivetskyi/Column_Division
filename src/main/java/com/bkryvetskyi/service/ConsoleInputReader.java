package com.bkryvetskyi.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputReader implements AutoCloseable {
    private final Scanner scanner;
    private static final Logger LOGGER = LogManager.getLogger(ConsoleInputReader.class);
    private static final int MAX_INT_VALUE = Integer.MAX_VALUE;

    public ConsoleInputReader() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt() {
        LOGGER.info("Enter a positive integer: ");

        while(true) {
            try {
                int number = scanner.nextInt();

                if (number <= 0) {
                    LOGGER.error("Invalid input, please enter a non-zero integer.");
                } else if (number > MAX_INT_VALUE) {
                    LOGGER.error("Invalid input, please enter a positive integer not exceeding " + MAX_INT_VALUE);
                } else {
                    return number;
                }
            } catch (InputMismatchException e) {
                LOGGER.error("Invalid input, please enter an integer.");
                scanner.nextLine();
            } catch (Exception e) {
                LOGGER.error("Unexpected error occurred. Please try again.");
                scanner.nextLine();
            }
        }
    }
    @Override
    public void close() {
        scanner.close();
    }
}
