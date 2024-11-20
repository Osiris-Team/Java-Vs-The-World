# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages and implementations.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Implementation       | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|----------------------|-------------------|-------------------|-------------------|-----------------------|
| c_clang              | 14507589          | 14.51             | 0.0145            | 0.00                  |
| c_gcc                | 14655454          | 14.66             | 0.0147            | 1.02                  |
| cpp_clang            | 25117038          | 25.12             | 0.0251            | 73.13                 |
| cpp                  | 25673876          | 25.67             | 0.0257            | 76.97                 |
| java_graalvm_native_optimized | 28051625          | 28.05             | 0.0281            | 93.36                 |
| java_optimized       | 35138748          | 35.14             | 0.0351            | 142.21                |
| java                 | 35518986          | 35.52             | 0.0355            | 144.83                |
| cpp_pgo              | 37424364          | 37.42             | 0.0374            | 157.96                |
| csharp               | 38881493          | 38.88             | 0.0389            | 168.01                |
| java_graalvm_jvm     | 41889034          | 41.89             | 0.0419            | 188.74                |
| java_graalvm_native  | 44082686          | 44.08             | 0.0441            | 203.86                |
| scala                | 74530884          | 74.53             | 0.0745            | 413.74                |
| js                   | 202993095         | 202.99            | 0.2030            | 1299.22               |
| python_pypy          | 217816352         | 217.82            | 0.2178            | 1401.40               |
| python               | 681937694         | 681.94            | 0.6819            | 4600.56               |
| python_nuitka        | 727313995         | 727.31            | 0.7273            | 4913.33               |

**Summary:**
- Fastest implementation: c_clang with 14.51 ms (0.0145 s).
- Slowest implementation: python_nuitka with 727.31 ms (0.7273 s).
