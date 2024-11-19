# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Language   | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|------------|-------------------|-------------------|-------------------|-----------------------|
| java       | 8611884           | 8.61              | 0.0086            | 0.00                  |
| js         | 10604914          | 10.60             | 0.0106            | 23.14                 |
| python     | 61839580          | 61.84             | 0.0618            | 618.07                |
| cpp        | 91514475          | 91.51             | 0.0915            | 962.65                |

**Summary:**
- Fastest language: java with 8.61 ms (0.0086 s).
- Slowest language: cpp with 91.51 ms (0.0915 s).
