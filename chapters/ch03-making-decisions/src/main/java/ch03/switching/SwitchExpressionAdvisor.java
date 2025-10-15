package ch03.switching;

/**
 * Shows modern switch expressions with arrow syntax and yield blocks.
 */
public final class SwitchExpressionAdvisor {

    private SwitchExpressionAdvisor() {
    }

    public static String ticketCategory(int age) {
        return switch (age) {
            case 0, 1, 2 -> "Infant";
            case 3, 4, 5 -> "Toddler";
            case 6, 7, 8, 9, 10, 11, 12 -> "Child";
            default -> {
                if (age < 0) {
                    throw new IllegalArgumentException("Age cannot be negative");
                }
                yield age >= 65 ? "Senior" : "Adult";
            }
        };
    }

    public static String crowdLevelForAttendance(int attendance) {
        return switch (attendance) {
            case 0 -> "Closed";
            case 1, 2, 3, 4, 5 -> "Quiet";
            case 6, 7, 8, 9, 10 -> "Moderate";
            default -> {
                int buckets = attendance / 10;
                yield buckets >= 5 ? "Packed" : "Busy";
            }
        };
    }
}
