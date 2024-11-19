# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages and implementations.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Implementation       | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|----------------------|-------------------|-------------------|-------------------|-----------------------|
| cpp_clang            | 24678347          | 24.68             | 0.0247            | 0.00                  |
| cpp                  | 27110031          | 27.11             | 0.0271            | 9.85                  |
| java_graalvm_native_optimized | 28700239          | 28.70             | 0.0287            | 16.30                 |
| java_graalvm_jvm     | 31518651          | 31.52             | 0.0315            | 27.72                 |
| java_optimized       | 34268541          | 34.27             | 0.0343            | 38.86                 |
| java                 | 34918282          | 34.92             | 0.0349            | 41.49                 |
| cpp_pgo              | 37655790          | 37.66             | 0.0377            | 52.59                 |
| java_graalvm_native  | 45301316          | 45.30             | 0.0453            | 83.57                 |
| js                   | 174911086         | 174.91            | 0.1749            | 608.76                |
| python_pypy          | 235081434         | 235.08            | 0.2351            | 852.58                |
| python_nuitka        | 728096008         | 728.10            | 0.7281            | 2850.34               |
| python               | 752319574         | 752.32            | 0.7523            | 2948.50               |

**Summary:**
- Fastest implementation: cpp_clang with 24.68 ms (0.0247 s).
- Slowest implementation: python with 752.32 ms (0.7523 s).
