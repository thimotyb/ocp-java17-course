package ch03.switching;

/**
 * Uses the classic switch statement with fall-through and default handling.
 */
public final class LegacySwitchPlanner {

    private LegacySwitchPlanner() {
    }

    public static String scheduleForDay(String day) {
        if (day == null) {
            return "Closed";
        }
        String normalized = day.toUpperCase();
        String message;
        switch (normalized) {
            case "SAT":
            case "SUN":
                message = "Weekend events";
                break;
            case "FRI":
                message = "Extended hours";
                break;
            case "MON":
                message = "Maintenance";
                break;
            default:
                message = "Standard schedule";
        }
        return message;
    }

    public static String mealForHour(int hour) {
        StringBuilder plan = new StringBuilder();
        switch (hour) {
            case 9:
            case 10:
                plan.append("Breakfast");
                break;
            case 11:
                plan.append("Brunch");
                // fall through intentionally
            case 12:
                plan.append(plan.isEmpty() ? "Lunch" : "/Lunch");
                break;
            default:
                plan.append("Snacks only");
        }
        return plan.toString();
    }
}
