def main():
    def f(s):
        r = 0
        for c in str(s):
            if c == '7' or c == '4':
                r += 1
        return r
    (n, k) = map(int, input().split(' '))
    a = list(map(int, input().split(' ')))
    x = 0
    for ai in a:
        if f(ai) <= k:
            x += 1
    return x

print(main())
