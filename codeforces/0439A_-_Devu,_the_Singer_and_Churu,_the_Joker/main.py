def main():
    (n, d) = map(int, input().split(' '))
    t = sorted(list(map(int, input().split(' '))))
    s = sum(t)
    if 10 * (n - 1) >= d:
        return -1

    time = 0
    jokes = 0
    for i, ti in enumerate(t):
        time += ti
        if time + 10 <= d:
            time += 10
            jokes += 2
        elif time + 5 <= d:
            time += 5
            jokes += 1
        elif i != n - 1:
            time += 10
    if time > d:
        return -1
    return jokes + (d - time) // 5

print(main())
