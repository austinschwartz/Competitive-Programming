def main():
    (n, m) = map(int, input().split(' '))
    mi = int(1e8)
    for x in range(100000):
        y = (n - x) // 2
        if y >= 0 and x + (2 * y) == n and (x + y) % m == 0:
            mi = min(mi, x + y)
    if mi == int(1e8):
        return -1
    return mi

print(main())
