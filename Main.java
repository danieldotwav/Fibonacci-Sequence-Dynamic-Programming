import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fib(1): Expected: 1, Actual: " + fib(1));
        System.out.println("Fib(2): Expected: 1, Actual: " + fib(2));
        System.out.println("Fib(3): Expected: 2, Actual: " + fib(3));

        System.out.println("Fib(6): Expected: 8, Actual: " + fib(6));
        System.out.println("Fib(7): Expected: 13, Actual: " + fib(7));
        System.out.println("Fib(8): Expected: 21, Actual: " + fib(8));

        // Using memoization, we can store intermediate fibonacci numbers
        HashMap<Integer, Long> solutions = new HashMap<Integer, Long>();
        System.out.println("Fib(50): Expected: 12586269025, Actual: " + fib_improved(50, solutions));
        System.out.println("Fib(27): Expected: 196418, Actual: " + fib_improved(27, solutions));
    }

    // This function, while technically correct, lacks efficiency
    // This approach has a time complexity of O(2^n) due to the number of recursive calls
    static int fib(int n) {
        // Base case
        if (n <= 2) {
            return 1;
        }

        // Return the sum of the previous two fibonacci numbers
        return fib(n - 1) + fib(n - 2);
    }

    // Improved fibonacci function uses dynamic programming to improve the time complexity
    static long fib_improved(int n, HashMap<Integer, Long> solutions) {
        // Base case
        if (n == 1 || n == 2) {
            return 1;
        }

        // Retrieve existing fib numbers from hashmap
        if (solutions.containsKey(n)) {
            return solutions.get(n);
        }

        // Store intermediate fibonacci values in the hash map
        long result = fib_improved(n - 1, solutions) + fib_improved(n - 2, solutions);
        solutions.put(n, result);

        return solutions.get(n);
    }
}
