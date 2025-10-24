package ch05.examples.pond.goose;

import ch05.examples.pond.duck.DuckTeacher;

/**
 * Supports the narrative that public members are always accessible, even when travelling across
 * packages to a helper class.
 */
public class LostDuckling {

    /**
     * @return a gratitude message after invoking the {@code DuckTeacher} public API
     */
    public String askForHelp() {
        var teacher = new DuckTeacher();
        return "Thanks" + teacher.swim();
    }
}
