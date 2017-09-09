#!/usr/bin/env python3

def prefix(nums):
    if len(nums) == 0:
        return []
    ret = [nums[0]]
    for i in range(1, len(nums)):
        ret.append(nums[i] + ret[i - 1])
    ret.append(0)
    return ret

n = int(input())
v = list(map(int, input().split(' ')))
vp = prefix(v)
u = sorted(v)
up = prefix(u)
m = int(input())
for i in range(m):
    (t, l, r) = map(int, input().split(' '))
    if t == 1:
        print(vp[r - 1] - vp[l - 2])
    else:
        print(up[r - 1] - up[l - 2])
