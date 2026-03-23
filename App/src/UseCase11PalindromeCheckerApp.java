public class UseCase11PalindromeCheckerApp {

    /**
     * Application entry point for UC11.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // Define the input string
        String input = "racecar";

        // Create an instance of PalindromeService
        PalindromeService service = new PalindromeService();

        // Call the encapsulated palindrome check method
        boolean isPalindrome = service.checkPalindrome(input);

        // Display the result
        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);
    }
}

/**
 * Service class that contains palindrome logic.
 */
class PalindromeService {

    /**
     * Checks whether the input string is a palindrome.
     *
     * @param input The string to validate
     * @return true if palindrome, otherwise false
     */
    public boolean checkPalindrome(String input) {

        // Initialize pointers
        int start = 0;
        int end = input.length() - 1;

        // Compare characters moving inward
        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                return false; // mismatch found
            }

            // Move pointers inward
            start++;
            end--;
        }

        return true; // all characters matched
    }
}
