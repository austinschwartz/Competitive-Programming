def main():
    (n, m, k) = map(int, input().split(' '))
    a = list(reversed(sorted(list(map(int, input().split(' '))))))
    ret = 0
    i = 0
    if k >= m:
        return 0
    while i < n:
        ret += 1
        k += (a[i] - 1)
        if k >= m:
            return ret
        i += 1
    if k < m:
        return -1
    return ret

print(main())
