def main():
    (n, t) = map(int, input().split(' '))
    a = list(map(int, input().split(' ')))
    p = [a[0]]
    for i in range(1, n):
        p.append(p[i-1] + a[i])
    i = 0
    j = 0
    m = 0
    while j < n:
        cur = p[j]
        if i > 0:
            cur -= p[i - 1]
        if cur <= t:
            m = max(m, j - i + 1)
        if cur < t:
            j += 1
        else:
            i += 1
    return m

print(main())

