package ch01.scope;

import java.util.ArrayList;
import java.util.List;

/**
 * Illustrates scope boundaries, local type inference, and final references.
 */
public final class ScopePlayground {

    public List<String> collectScopeMessages(boolean hungry, int portions) {
        var messages = new ArrayList<String>();
        messages.add("hungry=" + hungry);
        if (hungry) {
            var bitesOfCheese = 1;
            messages.add("bites=" + bitesOfCheese);
        }
        // messages.add("still=" + bitesOfCheese); // DOES NOT COMPILE: out of scope

        var consumed = calculatePortions(portions);
        messages.add("consumed=" + consumed);
        messages.add("final=" + demonstrateFinal());
        return List.copyOf(messages);
    }

    public int calculatePortions(int portions) {
        var remaining = Math.max(0, portions);
        var eaten = 0;
        while (remaining > 0) {
            var consumed = Math.min(remaining, 2);
            eaten += consumed;
            remaining -= consumed;
        }
        return eaten;
    }

    public String demonstrateFinal() {
        final var builder = new StringBuilder("base");
        builder.append("-extended");
        // builder = new StringBuilder("reset"); // DOES NOT COMPILE: final reference
        return builder.toString();
    }

    public boolean branchInitialization(boolean flag) {
        int answer;
        if (flag) {
            answer = 1;
        } else {
            answer = 2;
        }
        return answer > 0;
        // int other; return other > 0; // DOES NOT COMPILE: variable not initialised
    }
}
