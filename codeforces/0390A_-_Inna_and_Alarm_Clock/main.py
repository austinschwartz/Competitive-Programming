def main():
    n = int(input())
    r = set()
    c = set()
    for i in range(n):
        (x, y) = map(int, input().split(' '))
        r.add(y)
        c.add(x)
    return min(len(r), len(c))

print(main())
