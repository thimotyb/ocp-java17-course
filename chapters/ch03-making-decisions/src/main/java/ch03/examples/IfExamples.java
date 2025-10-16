package ch03.examples;

public final class IfExamples {

    private IfExamples() {
    }

    public static String greet(int hourOfDay) {
        if (hourOfDay < 11) {
            System.out.println("Good Morning");
            return "Good Morning";
        } else if (hourOfDay < 15) {
            System.out.println("Good Afternoon");
            return "Good Afternoon";
        } else {
            System.out.println("Good Evening");
            return "Good Evening";
        }
    }

    public static int morningGreetingCount(int hourOfDay) {
        int morningGreetingCount = 0;
        if (hourOfDay < 11) {
            System.out.println("Good Morning");
            morningGreetingCount++;
        }
        return morningGreetingCount;
    }
}
