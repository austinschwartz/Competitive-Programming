from fractions import gcd

def coprime(a, b):
    return gcd(a, b) == 1

l = int(input())
MAX = 2200

r = 0
for n in range(1, MAX):
    for m in range(n, MAX):
        if n % 2 == 1 and m % 2 == 1:
            continue
        if not coprime(n, m):
            continue
        for k in range(1, MAX):
            c = k * (m * m + n * n)
            if c > l:
                break
            r += 1
print(r)
