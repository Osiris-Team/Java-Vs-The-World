# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Language   | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|------------|-------------------|-------------------|-------------------|-----------------------|
| java       | 8962433           | 8.96              | 0.0090            | 0.00                  |
| js         | 10638161          | 10.64             | 0.0106            | 18.70                 |
| python     | 63608884          | 63.61             | 0.0636            | 609.73                |
| cpp        | 92567453          | 92.57             | 0.0926            | 932.84                |

**Summary:**
- Fastest language: java with 8.96 ms (0.0090 s).
- Slowest language: cpp with 92.57 ms (0.0926 s).
