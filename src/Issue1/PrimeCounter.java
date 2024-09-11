package Issue1;
import java.util.Scanner;

public class PrimeCounter {

    public static int countPrimesInRange(int start, int end) {
        // Check that start and end are valid
        if (start < 2 || end > 20000 || start > end) {
            return 0;
        }

        // Sieve of Eratosthenes to mark primes up to 20000
        int limit = 20000;
        boolean[] isPrime = new boolean[limit + 1];
        
        // Initialize all numbers as prime
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        
        // Apply the Sieve of Eratosthenes
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Count primes in the given range
        int primeCount = 0;
        for (int num = start; num <= end; num++) {
            if (isPrime[num]) {
                primeCount++;
            }
        }

        return primeCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input values
        System.out.print("Enter two integers (start and end): ");
        int start = scanner.nextInt();
        int end = scanner.nextInt();

        // Call the function to count primes
        int result = countPrimesInRange(start, end);

        // Output the result
        System.out.println(result);
        
        scanner.close();
    }
}
