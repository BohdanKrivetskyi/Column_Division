package com.bkryvetskyi.service;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputReader {
    private final Scanner scanner;
    private static final Logger LOGGER = LogManager.getLogger(ConsoleInputReader.class);

    public ConsoleInputReader() {
        this.scanner = new Scanner(System.in);
    }

    public int readInt() {
        LOGGER.info("Enter a positive integer: ");

        while(true) {
            try {
                int number = scanner.nextInt();
                scanner.nextLine();

                if (number <= 0) {
                    LOGGER.error("Invalid input, please enter a non-zero integer.");
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
}
