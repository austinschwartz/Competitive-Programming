(n, m, k) = map(int, input().split(' '))

a = list(map(int, input().split(' ')))

res = 1e8
m -= 1
for i in range(n):
    if a[i] == 0:
        continue
    dist = abs(m - i)
    if a[i] <= k:
        res = min(res, 10 * dist)
print(res)
