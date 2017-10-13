from collections import defaultdict, deque

def main():
    (n, k) = map(int, input().split(' '))
    s = list(input())
    m = defaultdict(int)
    for c in s:
        m[c] += 1
    l = deque(sorted([(x, m[x]) for x in m.keys()], key=lambda x: x[1]))
    ans = 0
    while k > 0:
        x = l.pop()
        r = x[1]
        if r <= k:
            k -= x[1]
        else:
            r = min(r, k)
            k = 0
        ans += (r * r)
    return ans

print(main())
