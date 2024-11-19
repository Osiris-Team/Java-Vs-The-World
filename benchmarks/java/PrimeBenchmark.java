import java.util.ArrayList;
import java.util.Random;

public class PrimeBenchmark {
    public static void main(String[] args) {
        Random random = new Random();
        int randomMax = 10000000 + random.nextInt(101); // Random number between 100000000 and 100000100

        long startTime, endTime;

        // First run (not timed)
        countPrimes(randomMax);

        // Second run (timed)
        startTime = System.nanoTime();
        countPrimes(randomMax);
        endTime = System.nanoTime();

        System.out.printf("{\"type\": \"prime\", \"time_ns\": %d}", (endTime - startTime));
    }

    private static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}