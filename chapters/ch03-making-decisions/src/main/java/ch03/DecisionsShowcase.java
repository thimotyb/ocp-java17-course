package ch03;

import ch03.ifelse.WeatherAdvisor;
import ch03.pattern.PatternDispatcher;
import ch03.switching.LegacySwitchPlanner;
import ch03.switching.SwitchExpressionAdvisor;

/**
 * Console entry point summarising the chapter 3 examples.
 */
public final class DecisionsShowcase {

    private DecisionsShowcase() {
    }

    public static void main(String[] args) {
        System.out.println(WeatherAdvisor.greetingWithForecast(9, "rain"));
        System.out.println(WeatherAdvisor.greetingWithForecast(18, 80));

        System.out.println(LegacySwitchPlanner.scheduleForDay("sat"));
        System.out.println(LegacySwitchPlanner.mealForHour(11));

        System.out.println(SwitchExpressionAdvisor.ticketCategory(72));
        System.out.println(SwitchExpressionAdvisor.crowdLevelForAttendance(55));

        System.out.println(PatternDispatcher.describe("zookeeper"));
        System.out.println(PatternDispatcher.switchDescribe(-5));
    }
}
