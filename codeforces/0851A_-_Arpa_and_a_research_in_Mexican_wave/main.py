def main(n, k, t):
    if t == 0 or t == n + k:
        return 0
    if t <= n:
        return min(t, k)
    return k - (t - n)

(n, k, t) = map(int, input().split(' '))
print(main(n, k, t))
