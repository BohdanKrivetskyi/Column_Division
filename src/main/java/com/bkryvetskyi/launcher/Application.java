package com.bkryvetskyi.launcher;

import com.bkryvetskyi.service.ConsoleInputReader;
import com.bkryvetskyi.service.DivisionPrinter;


public class Application {
    public static void main(String[] args) {
        run();
    }
    private static void run() {
        ConsoleInputReader input = new ConsoleInputReader();
        DivisionPrinter divisionPrinter = new DivisionPrinter();
        divisionPrinter.printColumnDivision(String.valueOf(input.readInt()), input.readInt());
    }
}
