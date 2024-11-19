#include <iostream>
#include <vector>
#include <chrono>
#include <random>

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
    // Generate a random number between 100000000 and 100000100
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> dis(100000000, 100000100);
    int randomMax = dis(gen);

    // First run (not timed)
    countPrimes(randomMax);

    // Second run (timed)
    auto start = std::chrono::high_resolution_clock::now();
    countPrimes(randomMax);
    auto end = std::chrono::high_resolution_clock::now();

    std::cout << "{\"type\": \"prime\", \"time_ns\": "
              << std::chrono::duration_cast<std::chrono::nanoseconds>(end - start).count()
              << "}" << std::endl;

    return 0;
}