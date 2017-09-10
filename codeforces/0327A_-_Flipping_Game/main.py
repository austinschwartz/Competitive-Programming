#!/usr/bin/env python3

import sys

n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split(' ')))

arr = []
ones = 0

for i in range(0, n):
    if nums[i] == 1:
        ones += 1
        arr.append(-1)
    else:
        arr.append(1)

dp = [arr[0]]
for i in range(1, n):
    dp.append(max(arr[i] + dp[i - 1], arr[i]))

sys.stdout.write(str(max(dp) + ones) + "\n")

