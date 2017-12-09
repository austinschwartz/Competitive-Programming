def main(n, m, a):
    if n >= m:
        return True
    sums = []
    vis = set()
    for i in range(0, n):
        if a[i] == 0:
            return True
        for j in range(0, len(sums)):
            _sum = (sums[j] + a[i]) % m
            if _sum == 0:
                return True
            if _sum not in vis:
                sums.append(_sum)
                vis.add(_sum)
        if a[i] not in vis:
            sums.append(a[i])
            vis.add(a[i])
    return 0 in sums
(n, m) = map(int, input().split(' '))
a = list(map(lambda i: int(i) % m, input().split(' ')))
print("YES" if main(n, m, a) else "NO")
