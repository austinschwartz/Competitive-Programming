from functools import cmp_to_key

def main():
    a = []
    b = []
    def f(i, j):
        nonlocal a, b
        if b[i] == b[j]:
            return a[j] - a[i]
        return b[j] - b[i]
    n = int(input())
    l = list(range(n))
    for i in range(n):
        (ai, bi) = map(int, input().split(' '))
        a.append(ai)
        b.append(bi)
    x = 1
    ans = 0
    l = sorted(l, key=cmp_to_key(f))
    for i in l:
        if x == 0:
            break
        x -= 1
        x += b[i]
        ans += a[i]
    return ans

print(main())
