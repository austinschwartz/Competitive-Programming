def main():
    (n, m) = map(int, input().split(' '))
    d = 0
    while n > 0:
        if d % m == 0:
            n += 1
        d += 1
        n -= 1
    return d - 1
print(main())
