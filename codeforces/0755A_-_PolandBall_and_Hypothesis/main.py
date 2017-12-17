def main():
    MAX = int(1e5)
    is_prime = [True] * MAX
    primes = set([2, 3])
    for i in range(2, MAX // 2):
        is_prime[i * 2] = False
    for i in range(3, MAX):
        if is_prime[i]:
            primes.add(i)
            for j in range(i * i, MAX, i):
                is_prime[j] = False
    m = int(input())
    for n in range(1, int(1e3)):
        if (n * m + 1) not in primes:
            return n
    return -1
print(main())
