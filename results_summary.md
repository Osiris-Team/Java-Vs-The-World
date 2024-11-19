# Prime Counting Benchmark Results

This file contains the results of running a prime-counting algorithm across various programming languages and implementations.

**Benchmark Details:**
- Problem size: Count primes up to 1,000,000.
- Environment: GitHub-hosted Ubuntu runners.
- Timings: Only the second run of the algorithm is measured for warm-up optimization.

| Implementation       | Time (ns)         | Time (ms)         | Time (s)          | % Slower than Fastest |
|----------------------|-------------------|-------------------|-------------------|-----------------------|
| java_graalvm         | 536506984         | 536.51            | 0.5365            | 0.00                  |
| java                 | 562157272         | 562.16            | 0.5622            | 4.78                  |
| java_graalvm_native_image | 725847055         | 725.85            | 0.7258            | 35.29                 |
| python_pypy          | 2172414779        | 2172.41           | 2.1724            | 304.92                |
| python               | 7173737764        | 7173.74           | 7.1737            | 1237.12               |
| js_graalvm           | 14424224434       | 14424.22          | 14.4242           | 2588.54               |
| js                   | 29465145197       | 29465.15          | 29.4651           | 5392.03               |

**Summary:**
- Fastest implementation: java_graalvm with 536.51 ms (0.5365 s).
- Slowest implementation: js with 29465.15 ms (29.4651 s).
