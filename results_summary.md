# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages and implementations.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Implementation       | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|----------------------|-------------------|-------------------|-------------------|-----------------------|
| cpp                  | 271872880         | 271.87            | 0.2719            | 0.00                  |
| java_graalvm         | 521071964         | 521.07            | 0.5211            | 91.66                 |
| java                 | 534702917         | 534.70            | 0.5347            | 96.67                 |
| java_graalvm_native_image | 691656507         | 691.66            | 0.6917            | 154.40                |
| python_pypy          | 2244343757        | 2244.34           | 2.2443            | 725.51                |
| python               | 7069125890        | 7069.13           | 7.0691            | 2500.16               |
| js_graalvm           | 14480469100       | 14480.47          | 14.4805           | 5226.19               |
| js                   | 28899178342       | 28899.18          | 28.8992           | 10529.67              |

**Summary:**
- Fastest implementation: cpp with 271.87 ms (0.2719 s).
- Slowest implementation: js with 28899.18 ms (28.8992 s).
