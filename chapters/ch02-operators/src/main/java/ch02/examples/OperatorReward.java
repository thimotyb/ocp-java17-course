package ch02.examples;

public final class OperatorReward {

    private OperatorReward() {
    }

    public static Result calculate() {
        int cookies = 4;
        double reward = 3 + 2 * --cookies;
        return new Result(cookies, reward);
    }

    public static void main(String[] args) {
        Result result = calculate();
        System.out.print("Zoo animal receives: " + result.reward() + " reward points");
    }

    public record Result(int cookies, double reward) {
    }
}
