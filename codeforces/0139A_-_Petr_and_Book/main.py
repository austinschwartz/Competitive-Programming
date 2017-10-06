n = int(input())
a = list(map(int, input().split(' ')))

i = 0
while n > 0:
    n -= a[i]
    if n <= 0:
        break
    i = (i + 1) % 7

print(i + 1)
