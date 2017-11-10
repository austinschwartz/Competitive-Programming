from sys import stdin, stdout
from functools import cmp_to_key

def main():
    def cmp(i, j):
        nonlocal a, b
        if a[i] == a[j]:
            return b[i] - b[j]
        return a[i] - a[j]
    n = int(stdin.readline())
    a = []
    b = []
    for i in range(n):
        (ai, bi) = map(int, stdin.readline().strip().split(' '))
        a.append(ai)
        b.append(bi)
    s = sorted(range(n), key=cmp_to_key(cmp))
    ans = 0
    for i in range(n):
        if ans <= b[s[i]]:
            ans = b[s[i]]
        else:
            ans = a[s[i]]
    return ans

stdout.write('{}\n'.format(main()))
