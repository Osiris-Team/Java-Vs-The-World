function countPrimes(n) {
    const isPrime = Array(n + 1).fill(true);
    isPrime[0] = isPrime[1] = false;
    for (let i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (let j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    return isPrime.reduce((count, val) => count + (val ? 1 : 0), 0);
}

// First run (not timed)
countPrimes(100000000);

// Second run (timed)
const start = process.hrtime.bigint();
countPrimes(100000000);
const end = process.hrtime.bigint();

console.log(`{"type": "prime", "time_ns": ${end - start}}`);