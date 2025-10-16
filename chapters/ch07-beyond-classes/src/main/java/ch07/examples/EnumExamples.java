package ch07.examples;

public final class EnumExamples {

    private EnumExamples() {
    }

    public enum Season {
        WINTER(5) {
            @Override
            public String activity() {
                return "Hibernate";
            }
        },
        SPRING(15),
        SUMMER(25) {
            @Override
            public String activity() {
                return "Swim";
            }
        },
        AUTUMN(10);

        private final int averageTemperature;

        Season(int averageTemperature) {
            this.averageTemperature = averageTemperature;
        }

        public int getAverageTemperature() {
            return averageTemperature;
        }

        public String activity() {
            return "Stroll";
        }
    }

    public enum ZooTrainTour {
        NORTH("Penguins"),
        SOUTH("Reptiles"),
        EAST("Savannah"),
        WEST("Bears");

        private final String highlight;

        ZooTrainTour(String highlight) {
            this.highlight = highlight;
        }

        public String getHighlight() {
            return highlight;
        }
    }
}
