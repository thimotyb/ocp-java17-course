package ch05.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch05.examples.pond.duck.BadDuckling;
import ch05.examples.pond.duck.DuckTeacher;
import ch05.examples.pond.duck.GoodDuckling;
import ch05.examples.pond.goose.Gosling;
import ch05.examples.pond.goose.Goose;
import ch05.examples.pond.goose.LostDuckling;
import ch05.examples.pond.swan.BadCygnet;
import ch05.examples.pond.swan.Swan;
import ch05.examples.pond.shore.BirdWatcher;
import org.junit.jupiter.api.Test;

class AccessModifierExamplesTest {

    @Test
    void packageAccessAllowsGoodDuckling() {
        assertEquals("quack", new GoodDuckling().learnToQuack());
    }

    @Test
    void badDucklingReliesOnFatherDuckInternals() {
        assertEquals("cannot access", new BadDuckling().attemptMakeNoise());
    }

    @Test
    void badCygnetCannotAccessPackageMembers() {
        assertEquals("cannot access", new BadCygnet().attemptNoise());
    }

    @Test
    void goslingInheritsProtectedMembers() {
        assertEquals("floatingfloating", new Gosling().swim());
    }

    @Test
    void birdWatcherWithinPackageCanAccessProtectedMembers() {
        assertEquals("floatingfloating", new BirdWatcher().watchBird());
    }

    @Test
    void swanCanHelpItsOwnKind() {
        var swan = new Swan();
        assertEquals("floatingfloating", swan.swim());
        assertEquals("floatingfloating", swan.helpOtherSwanSwim());
        assertEquals("cannot access", swan.helpOtherBirdSwim());
    }

    @Test
    void gooseCannotExposeProtectedMembersToOtherPackages() {
        assertEquals("floatingfloating", new Goose().helpGooseSwim());
        assertEquals("cannot access", new Goose().helpOtherGooseSwim());
    }

    @Test
    void duckTeacherPublicMembersAccessibleEverywhere() {
        assertEquals("Thankshelpful", new LostDuckling().askForHelp());
        assertEquals("helpful", new DuckTeacher().swim());
    }
}
