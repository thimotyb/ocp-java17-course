package ch03.ifelse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WeatherAdvisorTest {

    @Test
    void greetingChangesWithHour() {
        assertEquals("Good morning", WeatherAdvisor.greetingWithForecast(8, "clear"));
        assertEquals("Good afternoon", WeatherAdvisor.greetingWithForecast(13, "clear"));
        assertEquals("Good evening", WeatherAdvisor.greetingWithForecast(19, "clear"));
    }

    @Test
    void greetingUsesPatternMatchingForecast() {
        assertEquals("Good morning, remember an umbrella",
                WeatherAdvisor.greetingWithForecast(9, "rain"));
        assertEquals("Good afternoon, high chance of showers",
                WeatherAdvisor.greetingWithForecast(14, 80));
        assertEquals("Facility closed today",
                WeatherAdvisor.greetingWithForecast(10, Boolean.TRUE));
    }

    @Test
    void validatesHourRange() {
        assertThrows(IllegalArgumentException.class,
                () -> WeatherAdvisor.greetingWithForecast(24, "clear"));
    }

    @Test
    void discountForHolidayOrSevereWeather() {
        assertTrue(WeatherAdvisor.shouldOfferDiscount(true, false));
        assertTrue(WeatherAdvisor.shouldOfferDiscount(false, true));
    }
}
