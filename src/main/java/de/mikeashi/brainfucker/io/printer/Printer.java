package de.mikeashi.brainfucker.io.printer;

/**
 * the Printer class implements the output interface to provide the print method.
 *
 * @author Mike Ashi
 */
public class Printer implements output{

    @Override
    public void print(char c) {
        System.out.print(c);
    }
}
