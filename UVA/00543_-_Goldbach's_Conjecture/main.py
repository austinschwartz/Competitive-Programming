#!/usr/bin/env python3

import sys, math, bisect

def get_primes(n):
    p = []
    a = [True] * n
    for i in range(2, int(math.sqrt(n))):
        if a[i]:
            for j in range(i*i, n, i):
                a[j] = False
    for i, j in enumerate(a):
        if j and i > 1:
            p.append(i)
    return p

def main():
    p = get_primes(1000000)
    p_set = set(p)
    while True:
        n = int(sys.stdin.readline())
        if n == 0:
            return
        i = bisect.bisect(p, n)
        a = 0
        b = 0
        for j in range(i-1, 0, -1):
            if (n - p[j]) not in p_set:
                continue
            a = p[j]
            b = n - a
            break
        sys.stdout.write("{} = {} + {}\n".format(n, min(a, b), max(a, b)))

main()
