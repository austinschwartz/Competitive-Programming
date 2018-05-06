def main():
    def m(a):
        return (len(a) + 1) // 2 - 1
    from bisect import insort
    (n, x) = map(int, input().split(' '))
    a = list(sorted(list(map(int, input().split(' ')))))
    if x not in a:
        insort(a, x)
    while a[m(a)] != x:
        if a[m(a)] < x:
            a = a + [int(1e5)]
        else:
            a = [1] + a
    return len(a) - n

print(main())
