package ch03.switching;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SwitchExpressionAdvisorTest {

    @Test
    void categorisesTicketHolders() {
        assertEquals("Infant", SwitchExpressionAdvisor.ticketCategory(2));
        assertEquals("Child", SwitchExpressionAdvisor.ticketCategory(7));
        assertEquals("Adult", SwitchExpressionAdvisor.ticketCategory(30));
        assertEquals("Senior", SwitchExpressionAdvisor.ticketCategory(70));
    }

    @Test
    void ticketCategoryRejectsNegative() {
        assertThrows(IllegalArgumentException.class,
                () -> SwitchExpressionAdvisor.ticketCategory(-1));
    }

    @Test
    void crowdLevelUsesYield() {
        assertEquals("Quiet", SwitchExpressionAdvisor.crowdLevelForAttendance(5));
        assertEquals("Busy", SwitchExpressionAdvisor.crowdLevelForAttendance(35));
        assertEquals("Packed", SwitchExpressionAdvisor.crowdLevelForAttendance(55));
    }
}
