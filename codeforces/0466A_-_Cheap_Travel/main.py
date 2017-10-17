def main():
    (n, m, a, b) = map(int, input().split(' '))

    ans = int(1e8)
    for x in range(10000):
        for y in range(10000):
            if x + m * y >= n:
                ans = min(ans, x*a + y*b)
    return ans

print(main())
