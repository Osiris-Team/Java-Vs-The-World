import time

def count_primes(n):
    is_prime = [True] * (n + 1)
    is_prime[:2] = [False, False]
    for i in range(2, int(n ** 0.5) + 1):
        if is_prime[i]:
            for j in range(i * i, n + 1, i):
                is_prime[j] = False
    return sum(is_prime)

# First run (not timed)
count_primes(100000000)

# Second run (timed)
start_time = time.time()
count_primes(100000000)
end_time = time.time()

print(f'{{"type": "prime", "time_ns": {int((end_time - start_time) * 1e9)}}}')