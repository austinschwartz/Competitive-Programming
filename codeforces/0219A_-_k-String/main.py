#!/usr/bin/env python3
import sys

k = int(sys.stdin.readline())
s = sorted(sys.stdin.readline().rstrip())

def f(x, k):
    d = {}
    for c in x:
        if c in d:
            d[c] += 1
        else:
            d[c] = 1
    g = 0
    for c in d:
        if d[c] % k != 0:
            return "-1"
        else:
            g = d[c] // k
    string = []
    for c in d:
        for i in range(d[c] // k):
            string.append(c)
    return ''.join(string) * k

print(f(s, k))

