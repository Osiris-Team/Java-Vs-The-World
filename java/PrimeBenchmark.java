
import java.util.stream.IntStream;

public class PrimeBenchmark {
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    public static long countPrimes(int limit) {
        return IntStream.range(2, limit).filter(PrimeBenchmark::isPrime).count();
    }

    public static void main(String[] args) {
        int limit = 1000000; // Example limit
        countPrimes(limit); // Warm-up run

        long start = System.currentTimeMillis();
        long count = countPrimes(limit);
        long end = System.currentTimeMillis();

        System.out.println("Java: " + (end - start) + " ms");
    }
}
