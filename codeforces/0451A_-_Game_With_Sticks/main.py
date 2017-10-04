(n, m) = map(int, input().split(' '))

a = ["Malvika", "Akshat"]
i = False
while True:
    if n < 1 or m < 1:
        break
    m -= 1
    n -= 1
    i ^= True

print(a[i])
