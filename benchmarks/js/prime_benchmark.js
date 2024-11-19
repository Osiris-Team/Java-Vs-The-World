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

// Generate a random number between 10000000 and 10000100
const randomMax = 10000000 + Math.floor(Math.random() * 101);

// First run (not timed)
countPrimes(randomMax);

// Second run (timed)
const start = process.hrtime.bigint();
countPrimes(randomMax);
const end = process.hrtime.bigint();

console.log(`{"type": "prime", "time_ns": ${end - start}}`);