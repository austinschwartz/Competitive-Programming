from math import sqrt

def main():
    (r, d) = map(int, input().split(' '))
    n = int(input())
    ans = 0
    for i in range(n):
        (xi, yi, ri) = map(int, input().split(' '))
        if sqrt(xi*xi + yi*yi) + ri <= r:
            if sqrt(xi*xi + yi*yi) - ri >= r - d:
                ans += 1
    return ans

print(main())
