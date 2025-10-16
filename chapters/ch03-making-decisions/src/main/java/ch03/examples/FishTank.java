package ch03.examples;

public final class FishTank {

    private FishTank() {
    }

    public static String getFish(Object fish) {
        StringBuilder output = new StringBuilder();
        if (!(fish instanceof String guppy)) {
            output.append("Eat!");
        } else if (!(fish instanceof String guppy2)) {
            throw new RuntimeException();
        }
        output.append("Swim!");
        return output.toString();
    }
}
