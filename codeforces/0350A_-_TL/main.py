def f(a, b, v):
    if v < a[-1]:
        return False
    if v >= b[0]:
        return False
    extra = False
    for ai in a:
        if 2 * ai <= v:
            return ai
    return False

def main():
    (n, m) = map(int, input().split(' '))

    a = sorted(list(map(int, input().split(' '))))
    b = sorted(list(map(int, input().split(' '))))

    for v in range(1, b[0]):
        if f(a, b, v):
            return v

    return -1

print(main())



