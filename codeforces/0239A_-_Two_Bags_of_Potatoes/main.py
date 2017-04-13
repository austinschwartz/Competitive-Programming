(y, k, n) = map(int, input().split(' '))

lst = []

x = k - y % k
while x + y <= n:
    if (x + y) % k == 0:
        lst.append(x)
    x += k

if len(lst) == 0:
    print(-1)
else:
    print(' '.join(list(map(str,lst))))
