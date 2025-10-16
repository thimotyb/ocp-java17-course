package ch05.examples;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class VarargsExamplesTest {

    @Test
    void varargsLengthMatchesInput() {
        assertEquals(0, VarargsExamples.VarargUtilities.lengthOf());
        assertEquals(3, VarargsExamples.VarargUtilities.lengthOf(1, 2, 3));
    }

    @Test
    void varargsAllowsArrayAndIndividualArguments() {
        assertEquals(2, VarargsExamples.VarargUtilities.lengthOf(new int[] {4, 5}));
        assertEquals(77, VarargsExamples.VarargUtilities.secondElement(11, 77, 88));
    }

    @Test
    void dogWalkerDemonstratesConversions() {
        assertEquals(0, VarargsExamples.DogWalker.walkDog(1));
        assertEquals(1, VarargsExamples.DogWalker.walkDog(1, 2));
        assertEquals(2, VarargsExamples.DogWalker.walkDog(1, 2, 3));
        assertEquals(2, VarargsExamples.DogWalker.walkDogWithArray(1, new int[] {4, 5}));
    }

    @Test
    void passingNullThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> VarargsExamples.DogWalker.explodeOnNull(1, (int[]) null));
    }

    @Test
    void copyStepsCreatesDefensiveCopy() {
        int[] source = {1, 2, 3};
        int[] copy = VarargsExamples.copySteps(source);
        assertArrayEquals(source, copy);
        source[0] = 99;
        assertEquals(1, copy[0]);
    }
}
