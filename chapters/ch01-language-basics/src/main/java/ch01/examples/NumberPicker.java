package ch01.examples;

import java.util.Random;


public class NumberPicker {

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));
        System.out.println("Hey");
    }
    { System.out.println("Snowy"); } // Not executed initializer because the class is never instantiated
}
