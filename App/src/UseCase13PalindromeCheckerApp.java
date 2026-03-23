public class UseCase13PalindromeCheckerApp {

    /**
     * Application entry point for UC13.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Define the input string
        String input = "level";

        // ── Strategy 1: Stack Based ──────────────────────────
        long startStack = System.nanoTime();
        boolean resultStack = checkUsingStack(input);
        long endStack = System.nanoTime();
        long durationStack = endStack - startStack;

        // ── Strategy 2: Two Pointer Based ───────────────────
        long startPointer = System.nanoTime();
        boolean resultPointer = checkUsingTwoPointer(input);
        long endPointer = System.nanoTime();
        long durationPointer = endPointer - startPointer;

        // ── Strategy 3: StringBuilder Reverse ───────────────
        long startSB = System.nanoTime();
        boolean resultSB = checkUsingStringBuilder(input);
        long endSB = System.nanoTime();
        long durationSB = endSB - startSB;

        // ── Display Results ──────────────────────────────────
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + resultStack);
        System.out.println();
        System.out.println("---- Performance Comparison ----");
        System.out.println("Stack Strategy      : " + durationStack   + " ns");
        System.out.println("Two Pointer Strategy: " + durationPointer + " ns");
        System.out.println("StringBuilder       : " + durationSB      + " ns");
        System.out.println();

        // ── Determine Fastest ────────────────────────────────
        long fastest = Math.min(durationStack, Math.min(durationPointer, durationSB));

        if (fastest == durationStack) {
            System.out.println("Fastest Algorithm   : Stack Strategy");
        } else if (fastest == durationPointer) {
            System.out.println("Fastest Algorithm   : Two Pointer Strategy");
        } else {
            System.out.println("Fastest Algorithm   : StringBuilder Strategy");
        }
    }

    /**
     * Strategy 1: Stack-based palindrome check (LIFO).
     */
    private static boolean checkUsingStack(String input) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }

    /**
     * Strategy 2: Two pointer palindrome check.
     */
    private static boolean checkUsingTwoPointer(String input) {
        int start = 0;
        int end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    /**
     * Strategy 3: StringBuilder reverse palindrome check.
     */
    private static boolean checkUsingStringBuilder(String input) {
        String reversed = new StringBuilder(input).reverse().toString();
        return input.equals(reversed);
    }
}

