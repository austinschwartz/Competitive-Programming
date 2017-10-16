from collections import defaultdict
from functools import cmp_to_key

def main():
    n = int(input())
    m = defaultdict(int)
    for i in range(n):
        s = input().upper()
        for c in list(s):
            if c <= 'Z' and c >= 'A':
                m[c] += 1
    l = []
    for c in m:
        l.append((c, m[c]))
    def f(a, b):
        if a[1] == b[1]:
            return ord(a[0]) - ord(b[0])
        return b[1] - a[1]
    l = sorted(l, key=cmp_to_key(f))
    for (a, b) in l:
        print(a, b)

main()
