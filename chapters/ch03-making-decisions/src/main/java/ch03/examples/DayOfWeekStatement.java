package ch03.examples;

public final class DayOfWeekStatement {

    private DayOfWeekStatement() {
    }

    public static String printDayOfWeek(int day) {
        switch (day) {
            case 0:
                System.out.print("Sunday");
                return "Sunday";
            case 1:
                System.out.print("Monday");
                return "Monday";
            case 2:
                System.out.print("Tuesday");
                return "Tuesday";
            case 3:
                System.out.print("Wednesday");
                return "Wednesday";
            case 4:
                System.out.print("Thursday");
                return "Thursday";
            case 5:
                System.out.print("Friday");
                return "Friday";
            case 6:
                System.out.print("Saturday");
                return "Saturday";
            default:
                System.out.print("Invalid value");
                return "Invalid value";
        }
    }
}
