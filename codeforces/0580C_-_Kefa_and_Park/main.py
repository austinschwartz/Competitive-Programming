#!/usr/bin/env python3

import sys

adjList = []
cats = []
m = 0

def dfs(par, i, c):
    global adjList, cats, m
    if c > m:
        return 0
    visited = 0
    res = 0
    for j in adjList[i]:
        if j == par:
            continue
        visited += 1
        if cats[j] == 1:
            res += dfs(i, j, c + 1)
        else:
            res += dfs(i, j, 0)
    if visited == 0:
        res += 1
    return res

(n, m) = map(int, sys.stdin.readline().split(' '))
cats = list(map(int, sys.stdin.readline().split(' ')))
adjList = [[] for i in range(int(1e6) + 1)]
for i in range(n - 1):
    (x, y) = map(int, sys.stdin.readline().split(' '))
    adjList[x-1].append(y-1)
    adjList[y-1].append(x-1)
ret = dfs(-1, 0, cats[0])
sys.stdout.write('{}\n'.format(ret))

