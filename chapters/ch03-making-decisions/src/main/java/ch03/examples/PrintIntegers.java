package ch03.examples;

public class PrintIntegers {

    public static void main(String[] args) {
        int y = -2;
        do {
            System.out.print(++y + " ");
        } while (y <= 5);
    }
}
