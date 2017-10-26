def main():
    def s(x):
        r = 0
        while x > 0:
            r += (x % 10)
            x //= 10
        return r
    def f(a, b, c):
        r = []
        for sa in range(1, 82):
            x = b * (sa ** a) + c
            if b * s(x) ** a + c == x and x <= int(1e9):
                r.append(x)
        return r

    (a, b, c) = map(int, input().split(' '))
    r = f(a, b, c)
    print(len(r))
    if len(r) > 0:
        print(' '.join(list(map(str, r))))
main()
