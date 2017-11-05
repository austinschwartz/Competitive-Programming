def main(n, x, v):
    eps = 1e-7
    def f(p):
        nonlocal n, x, v
        t = 0.0
        for i in range(n):
            t = max(t, abs(x[i] - p) / v[i])
        return t
    low = 0
    high = 1e9
    while low + eps < high:
        mid = (high + low) / 2
        midd = (mid + high) / 2
        if f(mid) < f(midd):
            high = midd
        else:
            low = mid
    return f(low)

print(main(int(input()), list(map(int, input().split(' '))), list(map(int, input().split(' ')))))
