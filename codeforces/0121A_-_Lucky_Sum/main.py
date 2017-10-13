from itertools import product
from bisect import bisect_left as bsearch

MAXDIG = 11

def main():
    global MAXDIG
    (l, r) = map(int, input().split(' '))
    luckies = []
    for i in range(MAXDIG):
        lst = product([7, 4], repeat = i)
        for x in lst:
            s = ''.join(map(str, x))
            if len(s) != 0:
                num = int(s)
                luckies.append(num)
    luckies = sorted(luckies)
    i = bsearch(luckies, l)
    j = bsearch(luckies, r)
    s = 0
    n = r - l + 1
    left = n
    while luckies[i] <= luckies[j]:
        dif = min(luckies[i] - l + 1, left)
        left -= dif
        l += dif
        s += (dif * luckies[i])
        i += 1
    return s

print(main())

