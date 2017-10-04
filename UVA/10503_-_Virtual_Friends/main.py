import sys
from random import random

par = []

def find(i):
    if par[i] == i:
        return i
    par[i] = find(par[i])
    return par[i]

def union(i, j):
    global par
    p = find(i)
    q = find(j)
    if random() < 0.5:
        par[p] = q
    else:
        par[q] = p

T = int(sys.stdin.readline())
for t in range(T):
    m = int(sys.stdin.readline())
    dic = {}
    rev = []
    n = 0
    par = list(range(200000))
    for i in range(m):
        (a, b) = sys.stdin.readline().rstrip().split(' ')
        if a not in dic:
            dic[a] = n
            rev.append(a)
            n += 1
        if b not in dic:
            dic[b] = n
            rev.append(b)
            n += 1
        union(dic[b], dic[a])
        count = 0
        for i in range(n):
            if find(par[i]) == par[dic[b]]:
                count += 1
        sys.stdout.write('{}\n'.format(count))

