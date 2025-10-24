package ch11.examples;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Demonstrates locale-sensitive formatting and resource bundle access described in Chapter 11
 * "Working with Localization". Methods cover locale creation, number/date formatting, parsing, and
 * resource bundle lookups.
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c11.xhtml">OCP Java SE 17 Study Guide – Chapter 11: Working with Localization</a>
 */
public final class LocalizationExamples {

    private LocalizationExamples() {
    }

    /** @return new {@link Locale} built from the language and country codes introduced in the text */
    public static Locale createLocale(String language, String country) {
        return new Locale(language, country);
    }

    /**
     * Formats currency according to the supplied locale using {@link NumberFormat}.
     */
    public static String formatCurrency(double amount, Locale locale) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(amount);
    }

    /**
     * Parses a localized currency string, illustrating {@link NumberFormat#parse(String)}.
     */
    public static double parseCurrency(String text, Locale locale) throws ParseException {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.parse(text).doubleValue();
    }

    /**
     * Formats a date/time combination using {@link DateTimeFormatter#ofLocalizedDateTime(FormatStyle)}
     * with locale and zone adjustments.
     */
    public static String formatDateTime(LocalDate date, LocalTime time, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            .withLocale(locale)
            .withZone(ZoneId.systemDefault());
        return formatter.format(date.atTime(time));
    }

    /**
     * Retrieves a resource bundle message, matching the basic lookup example in the chapter.
     */
    public static String resourceBundleMessage(String baseName, Locale locale, String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        return bundle.getString(key);
    }

    /**
     * @return sorted list of available keys from the located resource bundle
     */
    public static List<String> availableBundleKeys(String baseName, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        return bundle.keySet().stream().sorted().toList();
    }

    /**
     * Throws a {@link MissingResourceException} when the requested key is absent, highlighting
     * defensive bundle usage.
     */
    public static void validateBundleKey(String baseName, Locale locale, String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        if (!bundle.containsKey(key)) {
            throw new MissingResourceException("Missing key", baseName, key);
        }
    }
}
