package ch11.examples;

import java.util.List;
import java.util.Locale;

/**
 * Launcher that exercises the Chapter 11 exception-handling and localization snippets, printing the
 * behaviour described in the study guide.
 */
public final class Chapter11Demo {

    private Chapter11Demo() {
    }

    public static void main(String[] args) throws Exception {
        try {
            ExceptionExamples.safeDivide(4, 0);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        System.out.println("Try-with-resources events: " + ExceptionExamples.tryWithResources());

        Locale italy = LocalizationExamples.createLocale("it", "IT");
        System.out.println("Currency: " + LocalizationExamples.formatCurrency(1234.56, italy));
        System.out.println("Date/time: " + LocalizationExamples.formatDateTime(java.time.LocalDate.now(), java.time.LocalTime.NOON, Locale.US));
    }
}
