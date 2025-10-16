package ch02.examples;

public final class OperatorIncrement {

    private OperatorIncrement() {
    }

    public static int[] demo() {
        int parkAttendance = 0;
        int firstPrint = parkAttendance;
        int secondPrint = ++parkAttendance;
        int thirdPrint = parkAttendance;
        int fourthPrint = parkAttendance--;
        int fifthPrint = parkAttendance;
        return new int[] {firstPrint, secondPrint, thirdPrint, fourthPrint, fifthPrint};
    }

    public static void main(String[] args) {
        int[] values = demo();
        for (int value : values) {
            System.out.println(value);
        }
    }
}
