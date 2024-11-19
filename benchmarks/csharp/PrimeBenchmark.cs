// File: Program.cs

using System;
using System.Diagnostics;

class PrimeBenchmark {
    static void Main(string[] args) {
        Random random = new Random();
        int randomMax = 10000000 + random.Next(101); // Random number between 10000000 and 10000100

        // First run (not timed)
        CountPrimes(randomMax);

        // Second run (timed)
        var stopwatch = Stopwatch.StartNew();
        CountPrimes(randomMax);
        stopwatch.Stop();

        long time_ns = stopwatch.ElapsedTicks * (1_000_000_000L) / Stopwatch.Frequency;
        Console.WriteLine($"{{\"type\": \"prime\", \"time_ns\": {time_ns}}}");
    }

    private static int CountPrimes(int n) {
        bool[] isPrime = new bool[n + 1];
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