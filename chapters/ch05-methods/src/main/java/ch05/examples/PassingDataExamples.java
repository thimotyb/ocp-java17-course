package ch05.examples;

/**
 * Recreates the Chapter 5 walkthrough on Java's pass-by-value parameter model.
 *
 * <p>From Chapter 5: {@code Passing Data among Methods} — the book emphasises that:</p>
 * <ul>
 *   <li>Arguments are copied into method parameters (primitives copy the value; references copy
 *       the reference).</li>
 *   <li>Reassigning a parameter never changes the caller's variable.</li>
 *   <li>Mutating the object that a reference points to is visible to the caller.</li>
 *   <li>Return values are the mechanism for handing data back to the caller.</li>
 * </ul>
 */
public final class PassingDataExamples {

    private PassingDataExamples() {
    }

    /**
     * Mirrors the chapter's primitive example: the caller's copy is unchanged after the nested call.
     *
     * @param value the original primitive value
     * @return the same value received from the caller (demonstrates no reassignment leak)
     */
    public static int reassignPrimitive(int value) {
        newNumber(value);
        return value;
    }

    /**
     * Reassigns the local parameter, showing that the change does not escape the method.
     *
     * @param num the primitive parameter copy created for this method
     */
    public static void newNumber(int num) {
        num = 8; // reassignment has no effect on caller
    }

    /**
     * Uses an immutable {@link String} to demonstrate that reassigning the parameter leaves the
     * caller's variable untouched.
     *
     * @param name original caller value
     * @return the same reference passed in
     */
    public static String reassignString(String name) {
        speak(name);
        return name;
    }

    /**
     * Attempts to change the reference to point at a new {@link String}, which only affects the
     * local copy described in Chapter 5.
     *
     * @param name local reference copy inside the method
     */
    public static void speak(String name) {
        name = "Georgette";
    }

    /**
     * Shows that mutating a shared object (such as {@link StringBuilder}) is visible after the call.
     *
     * @param builder reference supplied by the caller
     * @return the same instance, now carrying the additional text
     */
    public static StringBuilder mutateBuilder(StringBuilder builder) {
        mutate(builder);
        return builder;
    }

    /**
     * Appends to the provided builder, matching Figure 5.4 where both references see the change.
     *
     * @param s the mutable object shared with the caller
     */
    public static void mutate(StringBuilder s) {
        s.append("Georgette");
    }

    /**
     * Delegates to {@link #addTickets(int)} but demonstrates that the caller's copy is unaffected
     * because the method does not use the return value.
     *
     * @param tickets the original number of tickets
     * @return the unchanged value that the caller still has
     */
    public static int ticketsAfterCall(int tickets) {
        addTickets(tickets);
        return tickets;
    }

    /**
     * Shows the contrasting scenario in which the caller observes the returned modified value.
     *
     * @param guests original string of guests
     * @return the value returned by {@link #addGuests(String)}
     */
    public static String guestsAfterCall(String guests) {
        return addGuests(guests);
    }

    /**
     * Increments the parameter copy and returns the new value, illustrating that return values are
     * needed to propagate state back from a method.
     *
     * @param tickets parameter copy
     * @return the incremented value
     */
    public static int addTickets(int tickets) {
        tickets++;
        return tickets;
    }

    /**
     * Concatenates to the parameter copy and returns the new {@link String}, matching the book's
     * example where the caller must capture the return value to see the change.
     *
     * @param guests parameter copy
     * @return the concatenated value
     */
    public static String addGuests(String guests) {
        guests += "d";
        return guests;
    }
}
