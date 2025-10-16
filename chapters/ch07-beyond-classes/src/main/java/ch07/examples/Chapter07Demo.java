package ch07.examples;

import java.util.ArrayList;

public final class Chapter07Demo {

    private Chapter07Demo() {
    }

    public static void main(String[] args) {
        var mouse = new InterfaceBasicsExamples.FieldMouse();
        System.out.println("Mouse speed: " + mouse.getSpeed(2));

        var eagle = new InterfaceFeatureExamples.Eagle();
        eagle.fly(40);
        System.out.println(eagle.takeoff());

        System.out.println("Season activity: " + EnumExamples.Season.SUMMER.activity());

        var keeper = new RecordExamples.Keeper("Sam", 5);
        System.out.println("Keeper: " + keeper);

        System.out.println(SealedExamples.describe(new SealedExamples.Penguin()));

        var enclosure = new NestedTypeExamples.Enclosure("Big Cats");
        System.out.println(enclosure.caretakerReport("Alex"));

        var runs = new ArrayList<Integer>();
        FunctionalInterfaceExamples runner = runs::add;
        runner.sprint(12);
        System.out.println("Runs recorded: " + runs);
    }
}
