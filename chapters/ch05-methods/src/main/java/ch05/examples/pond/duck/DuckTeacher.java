package ch05.examples.pond.duck;

/**
 * Mirrors the Chapter 5 example where package-private access allows classes in
 * {@code pond.duck} to reach each other's members.
 */
public class DuckTeacher {

    /** Accessible to other types in the same package. */
    public final String name = "helpful";

    /**
     * @return the shared {@code name}, showing that public members are visible across packages too
     */
    public String swim() {
        return name;
    }
}
