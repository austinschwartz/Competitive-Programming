def main():
    n = int(input())
    g = []
    for i in range(4):
        g.append(list(map(int, input().split(' '))))
    for i in range(4):
        a = min(g[i][0], g[i][1])
        b = min(g[i][2], g[i][3])
        if a + b <= n:
            return "{} {} {}".format(i + 1, a, b + (n - a - b))
    return -1
print(main())

