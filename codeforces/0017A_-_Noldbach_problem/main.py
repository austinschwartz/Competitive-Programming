def main(n, k):
    MAX = 1200

    is_prime = [True] * (MAX + 10)
    primes = set()
    primes_list = []

    def sieve():
        nonlocal is_prime, primes, MAX, primes_list
        for i in range(2, MAX // 2):
            is_prime[2 * i] = False
        for i in range(3, MAX):
            if is_prime[i]:
                primes.add(i)
                for j in range(i * i, MAX, i):
                    if j > MAX:
                        break
                    is_prime[j] = False

    def f(u):
        nonlocal primes, is_prime, primes_list
        for i in range(len(primes_list) - 1):
            if primes_list[i] + primes_list[i + 1] + 1 == u:
                return True
            if primes_list[i] + primes_list[i + 1] + 1 > u:
                return False
        return False
    sieve()
    primes_list = sorted(list(primes))
    x = 0
    for i in range(2, n + 1):
        if i in primes:
            if f(i):
                x += 1
    if x >= k:
        return "YES"
    return "NO"

(n, k) = map(int, input().split(' '))
print(main(n, k))
