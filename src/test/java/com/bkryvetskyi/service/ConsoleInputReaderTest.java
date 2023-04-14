package com.bkryvetskyi.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputReaderTest {
    @Test
    void testReadIntValidInput() {
        // Arrange
        String input = "123\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleInputReader reader = new ConsoleInputReader();

        // Act
        int result = reader.readInt();

        // Assert
        assertEquals(123, result);
    }

    @Test
    void testReadIntInvalidInputNegativeNumber() {
        // Arrange
        String input = "-5\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleInputReader reader = new ConsoleInputReader();

        // Act
        int result = reader.readInt();

        // Assert
        assertEquals(10, result);
    }

    @Test
    void testReadIntInvalidInputNonInteger() {
        // Arrange
        String input = "abc\n15\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleInputReader reader = new ConsoleInputReader();

        // Act
        int result = reader.readInt();

        // Assert
        assertEquals(15, result);
    }

    @Test
    void testReadIntInvalidInputEmptyInput() {
        // Arrange
        String input = "\n25\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleInputReader reader = new ConsoleInputReader();

        // Act
        int result = reader.readInt();

        // Assert
        assertEquals(25, result);
    }

}