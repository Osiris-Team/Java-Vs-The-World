
#include <iostream>
#include <cmath>
#include <chrono>

bool is_prime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) return false;
    }
    return true;
}

int count_primes(int limit) {
    int count = 0;
    for (int i = 2; i < limit; ++i) {
        if (is_prime(i)) ++count;
    }
    return count;
}

int main() {
    int limit = 1000000; // Example limit
    count_primes(limit); // Warm-up run

    auto start = std::chrono::high_resolution_clock::now();
    int count = count_primes(limit);
    auto end = std::chrono::high_resolution_clock::now();

    std::cout << "C++: "
              << std::chrono::duration_cast<std::chrono::milliseconds>(end - start).count()
              << " ms" << std::endl;
    return 0;
}
