def main():
    (n, k) = map(int, input().split(' '))
    a = list(map(int, input().split(' ')))
    i = 0
    while k > 0 and i < n and a[i] < 0:
        a[i] *= -1
        k -= 1
        i += 1
    a = sorted(a)
    if k > 0:
        a[0] = a[0] * (-1)**k
    return sum(a)

print(main())
