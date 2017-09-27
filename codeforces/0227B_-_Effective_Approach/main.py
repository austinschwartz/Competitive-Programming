#!/usr/bin/env python3

import sys

def main():
    n = int(sys.stdin.readline())
    nums = list(map(int, sys.stdin.readline().split(' ')))
    d = {}
    for i in range(len(nums)):
        d[nums[i]] = i + 1

    m = int(sys.stdin.readline())
    bs = list(map(int, sys.stdin.readline().split(' ')))
    a = 0
    b = 0
    for bi in bs:
        a += d[bi]
        b += (n - d[bi] + 1)
    sys.stdout.write('{} {}\n'.format(a, b))

main()
