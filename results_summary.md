# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages and implementations.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Implementation       | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|----------------------|-------------------|-------------------|-------------------|-----------------------|
| c_clang              | 12580803          | 12.58             | 0.0126            | 0.00                  |
| c_gcc                | 13338502          | 13.34             | 0.0133            | 6.02                  |
| cpp_clang            | 24118988          | 24.12             | 0.0241            | 91.71                 |
| cpp                  | 27299174          | 27.30             | 0.0273            | 116.99                |
| java_graalvm_native_optimized | 29111552          | 29.11             | 0.0291            | 131.40                |
| java_graalvm_jvm     | 29283413          | 29.28             | 0.0293            | 132.76                |
| java_optimized       | 34244486          | 34.24             | 0.0342            | 172.20                |
| java                 | 34905619          | 34.91             | 0.0349            | 177.45                |
| cpp_pgo              | 38438574          | 38.44             | 0.0384            | 205.53                |
| java_graalvm_native  | 44452665          | 44.45             | 0.0445            | 253.34                |
| scala                | 72786299          | 72.79             | 0.0728            | 478.55                |
| js                   | 179856131         | 179.86            | 0.1799            | 1329.61               |
| python_pypy          | 215535879         | 215.54            | 0.2155            | 1613.21               |
| python               | 680478334         | 680.48            | 0.6805            | 5308.86               |
| python_nuitka        | 741626262         | 741.63            | 0.7416            | 5794.90               |

**Summary:**
- Fastest implementation: c_clang with 12.58 ms (0.0126 s).
- Slowest implementation: python_nuitka with 741.63 ms (0.7416 s).
