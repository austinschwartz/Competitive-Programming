def main():
    n = int(input())
    l = []
    minx = int(1e8)
    maxx = int(-1e8)
    miny = int(1e8)
    maxy = int(-1e8)
    for i in range(n):
        (x, y) = map(int, input().split(' '))
        minx = min(minx, x)
        maxx = max(maxx, x)
        miny = min(miny, y)
        maxy = max(maxy, y)
    return (maxx - minx) * (maxy - miny)

print(main())
