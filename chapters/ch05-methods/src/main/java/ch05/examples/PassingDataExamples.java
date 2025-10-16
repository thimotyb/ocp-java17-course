package ch05.examples;

public final class PassingDataExamples {

    private PassingDataExamples() {
    }

    public static int reassignPrimitive(int value) {
        newNumber(value);
        return value;
    }

    public static void newNumber(int num) {
        num = 8; // reassignment has no effect on caller
    }

    public static String reassignString(String name) {
        speak(name);
        return name;
    }

    public static void speak(String name) {
        name = "Georgette";
    }

    public static StringBuilder mutateBuilder(StringBuilder builder) {
        mutate(builder);
        return builder;
    }

    public static void mutate(StringBuilder s) {
        s.append("Georgette");
    }

    public static int ticketsAfterCall(int tickets) {
        addTickets(tickets);
        return tickets;
    }

    public static String guestsAfterCall(String guests) {
        return addGuests(guests);
    }

    public static int addTickets(int tickets) {
        tickets++;
        return tickets;
    }

    public static String addGuests(String guests) {
        guests += "d";
        return guests;
    }
}
