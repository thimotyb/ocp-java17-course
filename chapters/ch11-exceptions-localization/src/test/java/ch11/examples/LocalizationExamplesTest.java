package ch11.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;

import org.junit.jupiter.api.Test;

class LocalizationExamplesTest {

    private static final Locale US = Locale.US;

    @Test
    void formatAndParseCurrency() throws ParseException {
        double amount = 1234.56;
        String formatted = LocalizationExamples.formatCurrency(amount, US);
        double parsed = LocalizationExamples.parseCurrency(formatted, US);
        assertEquals(amount, parsed, 0.001);
    }

    @Test
    void formatDateTimeLocaleSpecific() {
        String formatted = LocalizationExamples.formatDateTime(LocalDate.of(2024, 1, 15), LocalTime.NOON, US);
        // Example: Jan 15, 2024, 12:00:00 PM
        assertTrue(formatted.contains("Jan"));
    }

    @Test
    void resourceBundleMessages() {
        Locale locale = new Locale("en", "US");
        String message = LocalizationExamples.resourceBundleMessage("ch11.examples.zoo", locale, "hello");
        assertEquals("Hello", message);
        List<String> keys = LocalizationExamples.availableBundleKeys("ch11.examples.zoo", locale);
        assertTrue(keys.contains("hello"));
    }

    @Test
    void validateBundleKeyThrowsForMissing() {
        assertThrows(MissingResourceException.class, () -> LocalizationExamples.validateBundleKey("ch11.examples.zoo", Locale.US, "missing"));
    }
}
