package ch07.examples;

import java.util.Objects;

public final class RecordExamples {

    private RecordExamples() {
    }

    public record Keeper(String name, int experienceYears) {

        public Keeper {
            name = Objects.requireNonNull(name).trim();
            if (name.isEmpty()) {
                throw new IllegalArgumentException("name must not be blank");
            }
            if (experienceYears < 0) {
                throw new IllegalArgumentException("experience must be non-negative");
            }
        }

        public Keeper(String name) {
            this(name, 0);
        }
    }

    public record Exhibit(String title, int capacity) {

        public Exhibit {
            if (capacity <= 0) {
                throw new IllegalArgumentException("capacity must be positive");
            }
        }
    }
}
