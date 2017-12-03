from math import pi

def main():
    n = int(input())
    a = sorted(list(map(int, input().split(' '))))[::-1]
    area = 0
    f = 0
    for i in range(n):
        cur = pi * a[i] * a[i]
        if f:
            area += cur
        else:
            area -= cur
        f ^= 1
    return abs(area)
print(main())
