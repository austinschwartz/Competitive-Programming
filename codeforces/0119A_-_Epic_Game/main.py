from fractions import gcd

def main(a, b, n):
    p = 0
    while 1:
        if p == 0:
            g = gcd(a, n)
            if n < g:
                return "1"
        else:
            g = gcd(b, n)
            if n < g:
                return "0"
        n -= g
        p ^= 1
    return "??"
(a, b, n) = map(int, input().split(' '))
print(main(a, b, n))
