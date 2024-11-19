
import time

def is_prime(n):
    if n <= 1:
        return False
    if n <= 3:
        return True
    if n % 2 == 0 or n % 3 == 0:
        return False
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True

def count_primes(limit):
    return sum(1 for i in range(2, limit) if is_prime(i))

if __name__ == "__main__":
    limit = 1000000  # Example limit
    count_primes(limit)  # Warm-up run

    start = time.time()
    count = count_primes(limit)
    end = time.time()

    print(f"Python: {int((end - start) * 1000)} ms")
