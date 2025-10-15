package ch01.metrics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MetricsFormatterTest {

    private final MetricsFormatter formatter = new MetricsFormatter();

    @Test
    void formatsMetricsWithMultilineTemplate() {
        String actual = formatter.formatMetrics(5, Integer.valueOf(6), 2.5, Double.valueOf(3.75));
        String expected = String.join(System.lineSeparator(),
                "Metrics Report",
                "primitiveCount=5",
                "wrapperCount=6",
                "ratio=2.50",
                "milestone=3.75",
                "thousandSample=1000",
                "baseline=12345678");
        assertEquals(expected, actual);
    }

    @Test
    void formatLocaleAwareUsesWrapperConversion() {
        String actual = formatter.formatLocaleAware(3, Integer.valueOf(4));
        assertEquals("primitive=3, wrapper=4", actual);
    }
}
