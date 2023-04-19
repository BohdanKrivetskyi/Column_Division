package com.bkryvetskyi.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleInputReaderTest {
    @Test
    void readIntValidInput() {
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
    void readIntInputNegativeNumber() {
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
    void readIntInvalidInputNonInteger() {
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
    void readIntInvalidInputEmptyInput() {
        // Arrange
        String input = "\n25\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleInputReader reader = new ConsoleInputReader();

        // Act
        int result = reader.readInt();

        // Assert
        assertEquals(25, result);
    }

    @Test
    void readIntInvalidInputNoInteger() {
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
    void readIntInvalidInputGreaterThanInt() {
        // Arrange
        String input = "2147483648\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleInputReader reader = new ConsoleInputReader();

        // Act
        int result = reader.readInt();

        // Assert
        assertEquals(10, result);
    }

    @Test
    void readIntInvalidInputNegativeGreaterThanInt() {
        // Arrange
        String input = "-2147483649\n10\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleInputReader reader = new ConsoleInputReader();

        // Act
        int result = reader.readInt();

        // Assert
        assertEquals(10, result);
    }

    @Test
    void closeClosesScanner() {
        // Arrange
        ConsoleInputReader reader = new ConsoleInputReader();

        // Act
        reader.close();

        // Assert
        assertThrows(IllegalStateException.class, () -> reader.readInt());
    }
}