def main():
    (m, n) = map(int, input().split(' '))
    t = []
    for i in range(m):
        l = list(map(int, input().split(' ')))
        t.append(l)
    f = [0] * m
    for i in range(n):
        time = 0
        for j in range(m):
            s = max(time, f[j])
            f[j] = s + t[j][i]
            time = f[j]
    print(' '.join(list(map(str, f))))
main()
