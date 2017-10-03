import math

def sieve():
    MAX = int(1e6) * 2
    ret = []
    is_prime = [True] * MAX
    for i in range(2, int(math.sqrt(MAX))):
        if is_prime[i]:
            for j in range(2 * i, MAX, i):
                is_prime[j] = False
    for i in range(2, MAX):
        if is_prime[i]:
            ret.append(i)
    return ret


def main():
    n = int(input())
    primes = sieve()
    ret = sieve()[1:n + 1]
    if len(ret) < n:
        print("OOPS")
    else:
        print(' '.join(list(map(str, ret))))

main()
