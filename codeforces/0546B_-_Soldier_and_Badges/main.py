def main(n, a):
    ans = 0
    for i in range(1, n):
        if a[i] <= a[i - 1]:
            d = abs(a[i] - a[i - 1]) + 1
            ans += d
            a[i] += d
    return ans

print(main(int(input()), sorted(list(map(int, input().split(' '))))))
