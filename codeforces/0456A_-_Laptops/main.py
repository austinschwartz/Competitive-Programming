#!/usr/bin/env python3

import sys

n = int(sys.stdin.readline())

def is_alex_happy(lst):
    lst2 = sorted(lst, key=lambda x: x[0])
    for i in range(1, len(lst2)):
        if lst2[i][1] < lst2[i - 1][1]:
            return True
    return False

l = []
for i in range(n):
    (a, b) = map(int, sys.stdin.readline().split(' '))
    l.append((a, b))

if is_alex_happy(l):
    sys.stdout.write("Happy Alex\n")
else:
    sys.stdout.write("Poor Alex\n")

