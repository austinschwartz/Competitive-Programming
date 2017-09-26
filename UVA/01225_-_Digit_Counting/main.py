#!/usr/bin/env python3

import sys

def f(num):
    a = [0] * 10
    for i in range(1, num + 1):
        for c in list(str(i)):
            a[ord(c) - ord('0')] += 1
    return a

def main():
    T = int(sys.stdin.readline())
    for i in range(T):
        sys.stdout.write(' '.join(map(str, f(int(sys.stdin.readline())))) + '\n')

main()
