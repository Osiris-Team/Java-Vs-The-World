# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages and implementations.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Implementation       | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|----------------------|-------------------|-------------------|-------------------|-----------------------|
| cpp                  | 27649895          | 27.65             | 0.0276            | 0.00                  |
| java                 | 33976664          | 33.98             | 0.0340            | 22.88                 |
| java_graalvm         | 38718634          | 38.72             | 0.0387            | 40.03                 |
| java_graalvm_native_image | 47308140          | 47.31             | 0.0473            | 71.10                 |
| js                   | 115366631         | 115.37            | 0.1154            | 317.24                |
| python_pypy          | 196762084         | 196.76            | 0.1968            | 611.62                |
| python               | 674439191         | 674.44            | 0.6744            | 2339.21               |
| js_graalvm           | 1372159915        | 1372.16           | 1.3722            | 4862.62               |

**Summary:**
- Fastest implementation: cpp with 27.65 ms (0.0276 s).
- Slowest implementation: js_graalvm with 1372.16 ms (1.3722 s).
