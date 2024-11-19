# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages and implementations.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Implementation       | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|----------------------|-------------------|-------------------|-------------------|-----------------------|
| cpp                  | 2502253           | 2.50              | 0.0025            | 0.00                  |
| java_graalvm_native_image | 5068117           | 5.07              | 0.0051            | 102.54                |
| js                   | 10585991          | 10.59             | 0.0106            | 323.06                |
| python_pypy          | 11351585          | 11.35             | 0.0114            | 353.65                |
| java                 | 14055901          | 14.06             | 0.0141            | 461.73                |
| java_graalvm         | 19473649          | 19.47             | 0.0195            | 678.24                |
| python               | 61799049          | 61.80             | 0.0618            | 2369.74               |
| js_graalvm           | 143650044         | 143.65            | 0.1437            | 5640.83               |

**Summary:**
- Fastest implementation: cpp with 2.50 ms (0.0025 s).
- Slowest implementation: js_graalvm with 143.65 ms (0.1437 s).
