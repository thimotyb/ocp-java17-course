package ch05.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MethodDeclarationExamplesTest {

    @Test
    void parkTripAllowsValidMethods() {
        var trip = new MethodDeclarationExamples.ParkTrip();
        trip.skip1();
        trip.skip4();
    }

    @Test
    void exerciseSupportsDifferentSpecifierOrders() {
        MethodDeclarationExamples.Exercise.bike3();
        MethodDeclarationExamples.Exercise.bike4();
        var exercise = new MethodDeclarationExamples.Exercise();
        exercise.bike1();
        exercise.bike2();
        exercise.bike7();
    }

    @Test
    void hikeReturnLogicMatchesExamples() {
        var hike = new MethodDeclarationExamples.Hike();
        hike.hike1();
        hike.hike2();
        assertEquals("", hike.hike3());
        assertEquals("orange", hike.hike8(5));
        assertEquals("apple", hike.hike8(0));
    }

    @Test
    void measurementReturnsIntHeight() {
        assertEquals(9, new MethodDeclarationExamples.Measurement().getHeight1());
    }

    @Test
    void physicalEducationRunsValidMethods() {
        var pe = new MethodDeclarationExamples.PhysicalEducation();
        pe.run1();
        pe.run3(1);
        pe.run5(1, 2);
    }

    @Test
    void tripOverloadsCanBeInvoked() {
        var trips = new MethodDeclarationExamples.TripExamples();
        trips.visitZoo("Penguin", 5);
        trips.visitZoo(12, "Seals");
    }

    @Test
    void zooMonorailThrowsAsDocumented() {
        var monorail = new MethodDeclarationExamples.ZooMonorail();
        assertThrows(IllegalArgumentException.class, monorail::oneException);
        assertThrows(IllegalArgumentException.class, () -> monorail.twoExceptions());
    }

    @Test
    void lionTracksLocalAndInstanceVariables() {
        var lion = new MethodDeclarationExamples.Lion();
        int snack = lion.feedZooAnimals();
        assertEquals(11, snack);
        assertEquals(3, lion.getHunger());
    }

    @Test
    void veterinarianDeterminesRestAndFinalUsage() {
        var vet = new MethodDeclarationExamples.Veterinarian();
        assertEquals(5, vet.determineRest(true));
        assertEquals(20, vet.determineRest(false));
        vet.prepareCheckup();
        assertEquals(true, vet.effectivelyFinalExample());
    }

    @Test
    void polarBearFinalFieldsInitialised() {
        var bear = new MethodDeclarationExamples.PolarBear();
        assertEquals(10, bear.getAge());
        assertEquals(10, bear.getFishEaten());
        assertEquals("Robert", bear.getName());
    }
}
