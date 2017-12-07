def main():
    (n, x0, y0) = map(int, input().split(' '))
    slopes = set()
    for i in range(n):
        (x, y) = map(int, input().split(' '))
        if x != x0:
            slopes.add((y - y0) / (1.0 * (x - x0)))
        else:
            slopes.add("up")
    return len(slopes)

print(main())
