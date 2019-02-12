package de.mikeashi.brainfucker.io.reader;

import java.util.Scanner;

public class Reader implements input {
    Scanner sc = new Scanner(System.in);

    @Override
    public byte read() {
        System.out.print("-> ");
        return (byte) sc.next().charAt(0);
    }
}
