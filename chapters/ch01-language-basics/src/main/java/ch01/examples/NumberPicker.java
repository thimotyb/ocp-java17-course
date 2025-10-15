package ch01.examples;

import java.util.Random;

public class NumberPicker {

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));
    }
}
