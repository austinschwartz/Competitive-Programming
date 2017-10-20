from fractions import gcd

def main():
    (l, r) = map(int, input().split(' '))
    for a in range(l, r - 1):
        b = a + 1
        for c in range(b + 1, r + 1):
            if gcd(b, c) == 1 and gcd(a, c) != 1:
                return '{} {} {}'.format(a, b, c)
    return -1

print(main())
