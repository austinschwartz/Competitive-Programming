from fractions import gcd
from math import sqrt

d = []
ha = {}

def get_factors(a):
    se = set()
    for i in range(1, int(sqrt(a)) + 1):
        if a % i == 0:
            se.add(i)
            se.add(a // i)
    return se

def bsearch(l, h):
    if (l, h) in ha:
        return ha[(l, h)]
    global d
    for s in d:
        if s <= h and s >= l:
            ha[(l, h)] = s
            return s
    ha[(l, h)] = -1
    return -1

(a, b) = map(int, input().split(' '))

ad = get_factors(a)
bd = get_factors(b)
d = list(reversed(sorted(list(ad.intersection(bd)))))

n = int(input())

for i in range(n):
    (l, h) = map(int, input().split(' '))
    print(bsearch(l, h))
