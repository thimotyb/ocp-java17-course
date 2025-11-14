package ch03.examples;

/**
 * Demonstrates pattern matching with instanceof and flow scoping.
 * From Chapter 3: Making Decisions - Shortening Code with Pattern Matching.
 *
 * <p>Key Concepts:
 * <ul>
 *   <li>Pattern matching (Java 16+) combines instanceof check with casting</li>
 *   <li>Pattern variables are introduced with instanceof and a variable declaration</li>
 *   <li>Flow scoping determines where pattern variables are accessible</li>
 *   <li>Negated instanceof (!) affects pattern variable scope differently</li>
 *   <li>Compiler uses flow analysis to determine when a type is definitively known</li>
 * </ul>
 *
 * <p>Pattern Matching Syntax:
 * <pre>
 * // Traditional approach (verbose)
 * if (fish instanceof String) {
 *     String guppy = (String) fish;  // Explicit cast required
 *     System.out.print(guppy);
 * }
 *
 * // Pattern matching (concise)
 * if (fish instanceof String guppy) {  // Pattern variable 'guppy' declared
 *     System.out.print(guppy);         // No cast needed, type is String
 * }
 * </pre>
 *
 * <p>Flow Scoping Rules:
 * <ul>
 *   <li>Pattern variable is in scope only when compiler can definitively determine its type</li>
 *   <li>Unlike traditional scoping, flow scoping is based on program flow and branching</li>
 *   <li>With negation (!), the pattern variable is in scope OUTSIDE the if block</li>
 *   <li>Pattern variable can be used in the same expression where it's declared</li>
 * </ul>
 *
 * <p>Flow Scoping with Negation:
 * <pre>
 * if (!(obj instanceof String s)) {
 *     return;  // If this executes, obj is NOT a String
 * }
 * // After the if: we KNOW obj IS a String (otherwise we would have returned)
 * System.out.print(s);  // 's' is in scope here!
 * </pre>
 *
 * <p>Pattern Variable Scope Examples:
 * <ul>
 *   <li>{@code if (x instanceof String s)} - s is in scope inside if block only</li>
 *   <li>{@code if (!(x instanceof String s))} - s is in scope AFTER if block (with return/throw)</li>
 *   <li>{@code if (x instanceof String s && s.length() > 0)} - s can be used in same expression</li>
 *   <li>{@code if (x instanceof String s || s.length() > 0)} - DOES NOT COMPILE (s not in scope after ||)</li>
 * </ul>
 *
 * @see <a href="https://learning.oreilly.com/library/view/ocp-oracle-certified/9781119864585/c03.xhtml">Chapter 3: Making Decisions</a>
 */
public final class FishTank {

    private FishTank() {
    }

    /**
     * Demonstrates flow scoping with negated instanceof and pattern variables.
     *
     * <p>This example shows advanced flow scoping behavior that may appear on the exam.
     * The compiler uses flow analysis to determine where pattern variables are accessible
     * based on the logical flow of the code.
     *
     * <p>Execution Flow Analysis:
     * <ol>
     *   <li>First if: {@code if (!(fish instanceof String guppy))}
     *       <ul>
     *         <li>If fish is NOT a String: condition is true, append "Eat!", guppy not in scope</li>
     *         <li>If fish IS a String: condition is false, skip block, guppy not accessible</li>
     *       </ul>
     *   </li>
     *   <li>Second if: {@code else if (!(fish instanceof String guppy2))}
     *       <ul>
     *         <li>Only reached if first condition was false (fish IS a String)</li>
     *         <li>Condition checks if fish is NOT a String (but we know it IS)</li>
     *         <li>Condition is always false, so this branch never executes</li>
     *         <li>The throw statement is unreachable</li>
     *       </ul>
     *   </li>
     *   <li>After if/else: append "Swim!"
     *       <ul>
     *         <li>This line always executes</li>
     *         <li>No pattern variables are in scope here</li>
     *       </ul>
     *   </li>
     * </ol>
     *
     * <p>Possible Outputs:
     * <ul>
     *   <li>If fish is a String: "Swim!" (first condition false, second condition false)</li>
     *   <li>If fish is not a String: "Eat!Swim!" (first condition true, appends both)</li>
     * </ul>
     *
     * <p>Flow Scoping Explanation:
     * <ul>
     *   <li>Pattern variable 'guppy' in first if: NOT in scope anywhere (no return/throw)</li>
     *   <li>Pattern variable 'guppy2' in second if: NOT in scope anywhere (no return/throw)</li>
     *   <li>Without return/throw, negated pattern variables don't extend scope</li>
     *   <li>Compare to: {@code if (!(x instanceof String s)) return;} - then s IS in scope after</li>
     * </ul>
     *
     * <p>Why Second Condition Never Throws:
     * <ul>
     *   <li>To reach else-if, fish must be a String (first condition was false)</li>
     *   <li>Second condition checks if fish is NOT a String</li>
     *   <li>Since fish IS a String, this condition is always false</li>
     *   <li>The RuntimeException is never thrown</li>
     * </ul>
     *
     * <p>Example Usage:
     * <pre>
     * getFish("Nemo");     // Returns: "Swim!"
     * getFish(123);        // Returns: "Eat!Swim!"
     * getFish(null);       // Returns: "Eat!Swim!"
     * </pre>
     *
     * @param fish the object to check, expected to be a String for fish names
     * @return "Eat!Swim!" if fish is not a String, "Swim!" if fish is a String
     */
    public static String getFish(Object fish) {
        StringBuilder output = new StringBuilder();

        // First condition: if fish is NOT a String
        // Pattern variable 'guppy' is declared but not in scope outside this block
        if (!(fish instanceof String guppy)) {
            // This executes when fish is not a String (e.g., Integer, null, etc.)
            output.append("Eat!");
        } else if (!(fish instanceof String guppy2)) {
            // This branch is logically unreachable:
            // - To reach here, fish MUST be a String (first condition was false)
            // - This checks if fish is NOT a String (always false)
            // - Therefore, this RuntimeException never throws
            throw new RuntimeException();
        }

        // This line always executes (for both String and non-String inputs)
        // Pattern variables 'guppy' and 'guppy2' are not in scope here
        output.append("Swim!");

        return output.toString();
    }

    interface IAnimal{}
    interface IWildAnimal extends IAnimal{}

    void compareVariousNumbers(Number number) {

        if(number instanceof Integer data ) {
           //Integer data = (Integer)number;
           System.out.print(data);
           data = 10;
        }
     }

     // THIS DOES NOT COMPILE BECAUSE OF FLOW SCOPING
     void printIntegersOrNumbersGreaterThan5(Number number) {
        if(number instanceof Integer data && data.compareTo(5)>0)
           System.out.print(data);
     }


     void printIntegerTwice(Number number) {
        if (number instanceof Integer data)
        System.out.print(data.intValue());
        System.out.print(data.intValue());  // DOES NOT COMPILE
     }

     void printOnlyIntegers(Number number) { 
        if (!(number instanceof Integer data))
           return;
           
        System.out.print(data.intValue());
     }

}
