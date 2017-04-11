(n, m) = map(int, input().split(' '))


count = 0
while n < m:
    if m % 2:
        m += 1
    else:
        m //= 2
    count += 1
count += (n - m)
print(count)
