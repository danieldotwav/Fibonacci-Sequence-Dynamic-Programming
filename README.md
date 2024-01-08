# Fibonacci Sequence Using Dynamic Programming

## Project Overview
This Java project demonstrates two different approaches to calculating numbers in the Fibonacci sequence: a simple recursive method and an optimized version using dynamic programming with memoization.

### Algorithms Used

1. **Simple Recursive Method (`fib`):**
    - This method implements a straightforward recursive algorithm for calculating Fibonacci numbers.
    - Time Complexity: O(2^n) - Exponential
    - Space Complexity: O(n) - Linear (due to the recursion call stack)
    - **Drawback:** It involves a lot of repeated calculations, making it inefficient for larger values of `n`.

2. **Dynamic Programming with Memoization (`fib_improved`):**
    - This method improves upon the simple recursive method by storing already calculated Fibonacci numbers in a `HashMap`.
    - Time Complexity: O(n) - Linear
    - Space Complexity: O(n) - Linear (for storing the computed values in the hash map)
    - **Advantage:** Significantly faster for larger values of `n` as it avoids redundant calculations.

### Code Snippet

```java
import java.util.HashMap;

public class Main {
    static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static long fib_improved(int n, HashMap<Integer, Long> solutions) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (solutions.containsKey(n)) {
            return solutions.get(n);
        }
        long result = fib_improved(n - 1, solutions) + fib_improved(n - 2, solutions);
        solutions.put(n, result);
        return result;
    }
}
```

### Potential Improvements and Tradeoffs

- **Iterative Approach:** Implementing an iterative solution for the Fibonacci sequence can further reduce the space complexity to O(1), as it eliminates the need for a call stack or a hash map.
- **BigInteger for Large Numbers:** For extremely large values of `n`, using `long` may still lead to overflow. In such cases, `BigInteger` can be used, though it will have a performance impact.
- **Parallel Computing:** For further optimization, especially in a multi-core environment, parallel computing techniques can be explored. However, this adds complexity to the code and may not always lead to significant performance gains due to the overhead of thread management.

### Conclusion
This project illustrates the power of dynamic programming in optimizing recursive algorithms. By using memoization, the Fibonacci sequence calculation becomes feasible for large values of `n`, demonstrating a significant improvement over the simple recursive approach.
