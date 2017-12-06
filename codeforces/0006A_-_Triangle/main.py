def main(l):
    (a, b, c, d) = l
    if a + b > c or a + b > d or b + c > d:
        return "TRIANGLE"
    if a + b == c or a + b == d or b + c == d:
        return "SEGMENT"
    return "IMPOSSIBLE"

print(main(sorted(list(map(int, input().split(' '))))))
