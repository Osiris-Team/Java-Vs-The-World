
function isPrime(n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 === 0 || n % 3 === 0) return false;
    for (let i = 5; i * i <= n; i += 6) {
        if (n % i === 0 || n % (i + 2) === 0) return false;
    }
    return true;
}

function countPrimes(limit) {
    let count = 0;
    for (let i = 2; i < limit; i++) {
        if (isPrime(i)) count++;
    }
    return count;
}

const limit = 1000000; // Example limit
countPrimes(limit); // Warm-up run

const start = Date.now();
const count = countPrimes(limit);
const end = Date.now();

console.log(`JavaScript: ${end - start} ms`);
