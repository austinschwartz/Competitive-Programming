(n, k, d) = map(int, input().split(' '))

dp = [[-1 for i in range(202)] for j in range(2002)]

mod = int(1000000007)

def f(_sum, ok):
    if dp[_sum][ok] == -1 and _sum < n:
        ans = 0
        for i in range(1, k + 1):
            if ok == 0 and i >= d:
                ans += f(_sum + i, 1)
            else:
                ans += f(_sum + i, ok)
            ans = ans % mod
        dp[_sum][ok] = ans
        return ans

    if dp[_sum][ok] != -1 and _sum < n:
        return dp[_sum][ok]

    if _sum == n and ok == 1:
        dp[_sum][ok] = 1

    if _sum == n and ok == 0:
        dp[_sum][ok] = 0

    if _sum > n:
        dp[_sum][ok] = 0

    return dp[_sum][ok]

print(f(0, 0))
