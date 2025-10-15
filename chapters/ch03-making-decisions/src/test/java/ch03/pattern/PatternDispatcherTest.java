package ch03.pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PatternDispatcherTest {

    @Test
    void describeUsesInstanceofPatterns() {
        assertEquals("Blank string", PatternDispatcher.describe(" "));
        assertEquals("String length=4", PatternDispatcher.describe("zoo!"));
        assertEquals("Large integer", PatternDispatcher.describe(150));
        assertEquals("Number type=Double", PatternDispatcher.describe(5.5));
    }

    @Test
    void switchDescribeSupportsGuards() {
        assertEquals("No value", PatternDispatcher.switchDescribe(null));
        assertEquals("Blank string", PatternDispatcher.switchDescribe(""));
        assertEquals("Integer=7", PatternDispatcher.switchDescribe(7));
        assertEquals("Negative integer", PatternDispatcher.switchDescribe(-2));
    }
}
