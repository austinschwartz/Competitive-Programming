import sys
from functools import cmp_to_key
from bisect import bisect

def main():
    def c(a, b):
        if a[0] == b[0]:
            return b[1] - a[1]
        return a[0] - b[0]
    (n, k) = map(int, sys.stdin.readline().split(' '))

    l = []
    for i in range(n):
        (p, t) = map(int, sys.stdin.readline().split(' '))
        l.append((p, t))
    l = sorted(l, key=cmp_to_key(c), reverse=True)

    count = 1
    i = k
    while i < n and l[i][0] == l[k-1][0] and l[i][1] == l[k-1][1]:
        i += 1
        count += 1
    i = k - 2
    while i >= 0 and l[i][0] == l[k-1][0] and l[i][1] == l[k-1][1]:
        i -= 1
        count += 1
    sys.stdout.write('{}\n'.format(count))

main()
