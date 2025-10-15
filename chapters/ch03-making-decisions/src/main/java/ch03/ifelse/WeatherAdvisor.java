package ch03.ifelse;

/**
 * Demonstrates classic if/else chains combined with pattern matching.
 */
public final class WeatherAdvisor {

    private WeatherAdvisor() {
    }

    public static String greetingWithForecast(int hourOfDay, Object forecast) {
        if (hourOfDay < 0 || hourOfDay > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }

        String message;
        if (hourOfDay < 11) {
            message = "Good morning";
        } else if (hourOfDay < 17) {
            message = "Good afternoon";
        } else {
            message = "Good evening";
        }

        if (forecast instanceof String text && text.equalsIgnoreCase("rain")) {
            message += ", remember an umbrella";
        } else if (forecast instanceof Integer chance && chance > 60) {
            message += ", high chance of showers";
        } else if (forecast instanceof Boolean closed && closed) {
            message = "Facility closed today";
        }

        return message;
    }

    public static boolean shouldOfferDiscount(boolean holiday, boolean severeWeather) {
        if (holiday) {
            return true;
        }
        if (severeWeather) {
            return true;
        }
        return false;
    }
}
