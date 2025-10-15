package ch01.metrics;

import java.util.Locale;

/**
 * Formats primitive and wrapper values into a multi-line report.
 */
public final class MetricsFormatter {

    public String formatMetrics(int primitiveCount, Integer wrapperCount, double ratio, Double milestone) {
        if (wrapperCount == null || milestone == null) {
            throw new IllegalArgumentException("wrapperCount and milestone must be non-null");
        }
        var normalizedWrapper = Integer.valueOf(wrapperCount);
        var normalizedMilestone = Double.valueOf(milestone);
        var ratioWrapper = Double.valueOf(ratio);
        var thousandSample = 1_000;
        var baseline = 12_345_678;
        double milestoneValue = normalizedMilestone.doubleValue();
        double ratioValue = ratioWrapper.doubleValue();
        String template = String.join(System.lineSeparator(),
                "Metrics Report",
                "primitiveCount=%d",
                "wrapperCount=%d",
                "ratio=%.2f",
                "milestone=%.2f",
                "thousandSample=%d",
                "baseline=%d");
        return String.format(template,
                primitiveCount,
                normalizedWrapper,
                ratioValue,
                milestoneValue,
                thousandSample,
                baseline);
    }

    public String formatLocaleAware(int primitiveCount, Integer wrapperCount) {
        var value = Integer.valueOf(wrapperCount);
        return String.format(Locale.US, "primitive=%d, wrapper=%d", primitiveCount, value);
    }
}
