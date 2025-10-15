package it.tb.ocp.ch01;

public class SwitchExpressionsDemo {
    public static void main(String[] args) {
        int day = 5;
        String type = switch (day) {
            case 1, 7 -> "WEEKEND";
            case 2, 3, 4, 5, 6 -> "WEEKDAY";
            default -> throw new IllegalArgumentException("bad day: " + day);
        };
        System.out.println(type);
    }
}
