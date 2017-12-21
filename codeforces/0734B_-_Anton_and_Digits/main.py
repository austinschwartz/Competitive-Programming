def main():
    (k2, k3, k5, k6) = map(int, input().split(' '))
    x = min(k2, k5, k6)
    s = 0
    s += (256) * x
    k2 -= x
    k5 -= x
    k6 -= x

    y = min(k2, k3)
    s += (32) * y
    return s
print(main())
