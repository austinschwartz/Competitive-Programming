n = int(input())
cur = 0
m = 0
for i in range(n):
    (a, b) = map(int, input().split(' '))
    cur -= a
    cur += b
    m = max(m, cur)
print(m)
