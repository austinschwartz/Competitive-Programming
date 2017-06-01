(n, m) = map(int, input().split(' '))

f = list(map(int, input().split(' ')))

f = sorted(f)

res = 99999999
i = 0
j = n - 1

while j < m:
    res = min(res, f[j] - f[i])
    i += 1
    j += 1
print(res)
