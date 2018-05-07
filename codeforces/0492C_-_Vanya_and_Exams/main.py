def main():
    (n, r, avg) = map(int, input().split(' '))
    x = []
    points = 0
    essays = 0
    for i in range(n):
        a, b = map(int, input().split(' '))
        if a < r:
            x.append([a, b])
        points += a
    x = sorted(x, key=lambda i: i[1])
    i = 0
    while points < int(avg * n):
        t = min(int(avg * n - points), r - x[i][0])
        essays += int(t * x[i][1])
        points += t
        i += 1
    return essays
print(main())
