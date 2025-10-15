package ch01.examples;

/**
 * Direct transcription of the "Animal" example from Chapter 1.
 */
public class Animal {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int numberVisitors(int month) {
        return 10;
    }
}
