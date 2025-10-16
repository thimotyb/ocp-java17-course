package ch05.examples.pond.shore;

public class BirdWatcher {

    public String watchBird() {
        Bird bird = new Bird();
        return bird.floatInWater() + bird.text;
    }
}
