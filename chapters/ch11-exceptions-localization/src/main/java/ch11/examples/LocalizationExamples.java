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
 * Demonstrates locale-sensitive formatting and resource bundles.
 */
public final class LocalizationExamples {

    private LocalizationExamples() {
    }

    public static Locale createLocale(String language, String country) {
        return new Locale(language, country);
    }

    public static String formatCurrency(double amount, Locale locale) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(amount);
    }

    public static double parseCurrency(String text, Locale locale) throws ParseException {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.parse(text).doubleValue();
    }

    public static String formatDateTime(LocalDate date, LocalTime time, Locale locale) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
            .withLocale(locale)
            .withZone(ZoneId.systemDefault());
        return formatter.format(date.atTime(time));
    }

    public static String resourceBundleMessage(String baseName, Locale locale, String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        return bundle.getString(key);
    }

    public static List<String> availableBundleKeys(String baseName, Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        return bundle.keySet().stream().sorted().toList();
    }

    public static void validateBundleKey(String baseName, Locale locale, String key) {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName, locale);
        if (!bundle.containsKey(key)) {
            throw new MissingResourceException("Missing key", baseName, key);
        }
    }
}
