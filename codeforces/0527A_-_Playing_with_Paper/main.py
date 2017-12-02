def f(a, b):
    if a == b:
        return 1
    if b == 1:
        return a
    if a <= 0 or b <= 0:
        return 0
    r = 0
    while a > 0 and b > 0:
        if a >= b:
            r += a // b
            a = a % b
        else:
            r += b // a
            b = b % a
    return r

def main():
    return f(*list(map(int, input().split(' '))))

print(main())
