(n, a, b, c) = map(int, input().split(' '))

ss = set([a, b, c])

dp = [int(-1e8)] * 4001
dp[0] = 0

def solve(size):
    if size < 0:
        return int(-1e8)
    if dp[size] > 0:
        return dp[size]
    m = (-1e8)
    for s in ss:
        if size >= s:
            r = 1 + solve(size - s)
            if r > 0:
                m = max(r, m)
    dp[size] = m
    return m

print(solve(n))
