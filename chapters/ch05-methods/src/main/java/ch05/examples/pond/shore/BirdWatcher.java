package ch05.examples.pond.shore;

/**
 * Shows that classes in the same package as {@link Bird} can freely access its protected members,
 * matching the Chapter 5 illustration.
 */
public class BirdWatcher {

    /**
     * @return the concatenation of protected members accessed within the same package
     */
    public String watchBird() {
        Bird bird = new Bird();
        return bird.floatInWater() + bird.text;
    }
}
