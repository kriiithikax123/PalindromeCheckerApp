public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        // Define the input string
        String input = "level";

        // Inject StackStrategy at runtime
        PalindromeStrategy strategy = new StackStrategy();

        // Create checker with the selected strategy
        PalindromeChecker checker = new PalindromeChecker(strategy);

        // Execute and get result
        boolean isPalindrome = checker.check(input);

        // Display result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

/**
 * ============================================================
 * INTERFACE - PalindromeStrategy
 * ============================================================
 *
 * This interface defines a contract for all
 * palindrome checking algorithms.
 *
 * Any new algorithm must implement this interface
 * and provide its own validation logic.
 */
interface PalindromeStrategy {

    /**
     * Checks whether the given input is a palindrome.
     *
     * @param input String to validate
     * @return true if palindrome, false otherwise
     */
    boolean check(String input);
}

/**
 * ============================================================
 * CONCRETE STRATEGY - StackStrategy
 * ============================================================
 *
 * This class implements PalindromeStrategy interface.
 * It uses LIFO behavior to reverse characters
 * and compare them with the original sequence.
 */
class StackStrategy implements PalindromeStrategy {

    /**
     * Implements palindrome validation using Stack.
     *
     * @param input String to validate
     * @return true if palindrome, false otherwise
     */
    public boolean check(String input) {

        // Create a stack to store characters
        java.util.Stack<Character> stack = new java.util.Stack<>();

        // Push each character of the input string onto the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Compare characters by popping from the stack
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false; // mismatch found
            }
        }

        return true; // all characters matched
    }
}

/**
 * ============================================================
 * CONTEXT CLASS - PalindromeChecker
 * ============================================================
 *
 * This class holds a reference to a PalindromeStrategy.
 * It delegates the palindrome check to the injected strategy.
 */
class PalindromeChecker {

    // Strategy reference
    private PalindromeStrategy strategy;

    /**
     * Constructor to inject the strategy.
     *
     * @param strategy The algorithm to use
     */
    public PalindromeChecker(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Delegates check to the injected strategy.
     *
     * @param input String to validate
     * @return true if palindrome, false otherwise
     */
    public boolean check(String input) {
        return strategy.check(input);
    }
}
