def main():
    (n, m) = map(int, input().split(' '))
    ans = 0
    for i in range(n):
        line = list(map(int, input().split(' ')))
        for j in range(0, 2 * m, 2):
            if line[j] == 1 or line[j + 1] == 1:
                ans += 1
    return ans
print(main())
