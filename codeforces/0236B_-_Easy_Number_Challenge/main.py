MOD = 1073741824
(a, b, c) = map(int, input().split(' '))

maxProd = a * b * c
d = [0 for i in range(maxProd + 1)]
d[1] = 1

for i in range(2, maxProd + 1):
    d[i] = 2

for i in range(2, maxProd//2 + 1):
    for j in range(2 * i, maxProd + 1, i):
        d[j] += 1

ret = 0
for i in range(1, a + 1):
    for j in range(1, b + 1):
        for k in range(1, c + 1):
            ret = (ret + d[i * j * k]) % MOD

print(ret)
