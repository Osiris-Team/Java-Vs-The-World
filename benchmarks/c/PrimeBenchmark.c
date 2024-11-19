#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int countPrimes(int n);

int main() {
    srand(time(NULL));
    int randomMax = 10000000 + rand() % 101; // Random number between 10000000 and 10000100

    // First run (not timed)
    countPrimes(randomMax);

    // Second run (timed)
    struct timespec start, end;
    clock_gettime(CLOCK_MONOTONIC, &start);
    countPrimes(randomMax);
    clock_gettime(CLOCK_MONOTONIC, &end);

    long time_ns = (end.tv_sec - start.tv_sec) * 1e9 + (end.tv_nsec - start.tv_nsec);

    printf("{\"type\": \"prime\", \"time_ns\": %ld}", time_ns);

    return 0;
}

int countPrimes(int n) {
    char *isPrime = (char *)malloc((n + 1) * sizeof(char));
    if (isPrime == NULL) {
        fprintf(stderr, "Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }

    for (int i = 2; i <= n; i++) {
        isPrime[i] = 1;
    }

    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = 0;
            }
        }
    }

    int count = 0;
    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) count++;
    }

    free(isPrime);
    return count;
}