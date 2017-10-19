def main():
    (n, c) = map(int, input().split(' '))
    a = list(map(int, input().split(' ')))
    ma = 0
    for i in range(n-1):
        ma = max(a[i] - a[i + 1] - c, ma)
    return ma

print(main())
