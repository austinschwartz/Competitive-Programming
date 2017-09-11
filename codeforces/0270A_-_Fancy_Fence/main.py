#!/usr/bin/env python3

import sys, math

def f(a):
    return "YES" if 360 % (180 - a) == 0 else "NO"

t = int(sys.stdin.readline())

for i in range(t):
    a = int(sys.stdin.readline())
    sys.stdout.write(f(a) + "\n")

