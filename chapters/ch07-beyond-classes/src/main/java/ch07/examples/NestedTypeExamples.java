package ch07.examples;

public final class NestedTypeExamples {

    private NestedTypeExamples() {
    }

    public static final class Enclosure {

        private static String location = "North";
        private final String name;

        public Enclosure(String name) {
            this.name = name;
        }

        public static final class Status {

            private final String description;

            public Status(String description) {
                this.description = description;
            }

            public String label() {
                return location + " status: " + description;
            }
        }

        public final class Resident {

            private final String species;

            public Resident(String species) {
                this.species = species;
            }

            public String description() {
                return name + " houses " + species;
            }
        }

        public String caretakerReport(String caretaker) {
            final int rounds = 3;
            class CaretakerLog {

                String build() {
                    return caretaker + " completed " + rounds + " rounds in " + name;
                }
            }
            return new CaretakerLog().build();
        }

        public String anonymousCall() {
            return sound(() -> name + " quiet down" + " please");
        }

        private String sound(Noise noise) {
            return noise.sound();
        }
    }

    @FunctionalInterface
    public interface Noise {

        String sound();
    }
}
