def main():
    (a, b, c) = list(map(int, input().split(' ')))
    s = a + b + c
    if s % 2 != 0:
        return "Impossible"
    x = (a - c + b) // 2
    y = b - x
    z = c - y
    if x < 0 or y < 0 or z < 0:
        return "Impossible"
    return '{} {} {}'.format(x, y, z)

print(main())
