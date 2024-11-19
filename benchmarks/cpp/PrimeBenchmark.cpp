#include <iostream>
#include <vector>
#include <chrono>
#include <algorithm> // Needed for std::count

int countPrimes(int n) {
    std::vector<bool> isPrime(n + 1, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i * i <= n; ++i) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }
    return std::count(isPrime.begin(), isPrime.end(), true);
}

int main() {
    // First run (not timed)
    countPrimes(1000000);

    // Second run (timed)
    auto start = std::chrono::high_resolution_clock::now();
    countPrimes(1000000);
    auto end = std::chrono::high_resolution_clock::now();

    std::cout << "{\"type\": \"prime\", \"time_ns\": "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count()
              << "}" << std::endl;

    return 0;
}