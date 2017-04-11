(n, m) = map(int, input().split(' '))

count = 0

for a in range(0, 10000):
    if a + n*n - 2*n*a*a + a*a*a*a == m:
        b = n - a*a
        if a + b*b == m and b >= 0:
            count += 1
print(count)
