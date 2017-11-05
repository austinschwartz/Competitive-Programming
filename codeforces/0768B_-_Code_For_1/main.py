def main():
    ans = 0
    def length(n):
        if n <= 1:
            return 1
        x = length(n // 2)
        return x + length(n % 2) + x

    def f(n, i, j):
        nonlocal ans, l, r
        if n <= 1:
            if n == 1 and i >= l and j <= r:
                ans += 1
            return
        mid = (i + j) // 2
        if l <= mid:
            x = f(n // 2, i, mid - 1)
        y = f(n % 2, mid, mid)
        if r >= mid:
            z = f(n // 2, mid + 1, j)

    (n, l, r) = map(int, input().split(' '))
    l -= 1
    r -= 1
    f(n, 0, length(n) - 1)
    return ans

print(main())
