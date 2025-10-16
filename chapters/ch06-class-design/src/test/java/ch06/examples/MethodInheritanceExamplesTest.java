package ch06.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class MethodInheritanceExamplesTest {

    @Test
    void kangarooUsesParentWeight() {
        var kangaroo = new MethodInheritanceExamples.Kangaroo();
        assertEquals(70.0, kangaroo.getAverageWeight(), 0.0001);
    }

    @Test
    void bactrianCamelOverridesPublicMethod() {
        assertEquals(2, new MethodInheritanceExamples.BactrianCamel().getNumberOfHumps());
    }

    @Test
    void javanRhinoUsesCovariantReturnType() {
        var rhino = new MethodInheritanceExamples.JavanRhino();
        assertEquals("javan rhino", rhino.getName());
    }

    @Test
    void pandaHidesStaticMethodButFollowsRules() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        try {
            MethodInheritanceExamples.Bear.eat();
            MethodInheritanceExamples.Panda.eat();
        } finally {
            System.setOut(original);
        }
        assertEquals("Bear is eating" + System.lineSeparator() + "Panda is chewing" + System.lineSeparator(), out.toString());
    }

    @Test
    void meerkatVariableHidingDependsOnReference() {
        MethodInheritanceExamples.Meerkat meerkat = new MethodInheritanceExamples.Meerkat();
        MethodInheritanceExamples.Carnivore carnivore = meerkat;
        assertTrue(meerkat.hasFur);
        assertEquals(false, carnivore.hasFur);
    }

    @Test
    void penguinInheritsFinalMethods() {
        var penguin = new MethodInheritanceExamples.Penguin();
        assertTrue(penguin.hasFeathers());
    }

    @Test
    void sharkOverridesSwim() {
        var shark = new MethodInheritanceExamples.Shark();
        shark.swim(); // should be callable without exception
    }
}
