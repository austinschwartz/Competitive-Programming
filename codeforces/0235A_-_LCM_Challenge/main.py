def gcd(a, b):
    if a == 0:
        return b
    return gcd(b % a, a)

def lcm(a, b):
    return (a * b) // gcd(a, b)

def main(n):
    mi = 0
    for i in range(max(1, n - 50), n + 1):
        for j in range(max(1, n - 50), n + 1):
            for k in range(max(1, n - 50), n + 1):
                mi = max(mi, lcm(lcm(i, j), k))
    return mi

print(main(int(input())))
