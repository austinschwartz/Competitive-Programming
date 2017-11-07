def main(n, a):
    s = sum(a)
    if s % 2 == 0:
        return s
    if n == 1:
        return 0
    evens = list(filter(lambda ai: ai % 2 == 0, a))
    if len(evens) == 0:
        ma = a[0] + a[1]
    else:
        ma = evens[0]
    for i in range(n):
        if (s - a[i]) % 2 == 0:
            ma = max(ma, s - a[i])
    return ma

print(main(int(input()), list(sorted(list(map(int, input().split(' ')))))))
