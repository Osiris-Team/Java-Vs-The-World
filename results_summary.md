# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages and implementations.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Implementation       | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|----------------------|-------------------|-------------------|-------------------|-----------------------|
| java                 | 541303933         | 541.30            | 0.5413            | 0.00                  |
| java_graalvm         | 588249094         | 588.25            | 0.5882            | 8.67                  |
| java_graalvm_native_image | 767527362         | 767.53            | 0.7675            | 41.79                 |
| python_pypy          | 2203502416        | 2203.50           | 2.2035            | 307.07                |
| python               | 7312169313        | 7312.17           | 7.3122            | 1250.84               |
| js_graalvm           | 14470537846       | 14470.54          | 14.4705           | 2573.27               |
| js                   | 29552981635       | 29552.98          | 29.5530           | 5359.59               |

**Summary:**
- Fastest implementation: java with 541.30 ms (0.5413 s).
- Slowest implementation: js with 29552.98 ms (29.5530 s).
