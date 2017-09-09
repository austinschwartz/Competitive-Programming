#!/usr/bin/env python3
import sys

n = int(sys.stdin.readline())

h = [0] + list(map(int, sys.stdin.readline().split(' ')))

e = 0
ret = 0
for i in range(0, n):
    e += (h[i] - h[i + 1])
    if e < 0:
        ret += -e
        e = 0

print(ret)
