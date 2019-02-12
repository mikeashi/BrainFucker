package de.mikeashi.brainfucker.io.reader;

import java.util.Scanner;
/**
 * the Reader class implements the input interface to provide the read method.
 *
 * @author Mike Ashi
 */
public class Reader implements input {
    Scanner sc = new Scanner(System.in);

    @Override
    public byte read() {
        System.out.print("-> ");
        return (byte) sc.next().charAt(0);
    }
}
