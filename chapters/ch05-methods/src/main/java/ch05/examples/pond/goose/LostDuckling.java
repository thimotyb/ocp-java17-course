package ch05.examples.pond.goose;

import ch05.examples.pond.duck.DuckTeacher;

public class LostDuckling {

    public String askForHelp() {
        var teacher = new DuckTeacher();
        return "Thanks" + teacher.swim();
    }
}
