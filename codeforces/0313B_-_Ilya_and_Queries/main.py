#!/usr/bin/env python3
import sys

def prefix(A):
    if len(A) == 0:
        return []
    ret = [0]
    for i in range(0, len(A) - 1):
        x = 1 if  A[i] == A[i + 1] else 0
        ret.append(x + ret[i])
    ret.append(0)
    return ret

s = sys.stdin.readline()
p = prefix(s)
n = int(sys.stdin.readline())
for i in range(n):
    (l, r) = map(int, sys.stdin.readline().split(' '))
    sys.stdout.write(str((p[r - 1] - p[l - 1])) + "\n")

