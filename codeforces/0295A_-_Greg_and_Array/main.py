import sys

(n, m, k) = map(int, sys.stdin.readline().split(' '))

a = list(map(int, sys.stdin.readline().split(' ')))
b = [0] * ((int)(1e5) + 1)
c = [0] * ((int)(1e5) + 1)
l = []
r = []
d = []

for i in range(m):
    (li, ri, di) = map(int, sys.stdin.readline().split(' '))
    l.append(li)
    r.append(ri)
    d.append(di)

for i in range(k):
    (xi, yi) = map(int, sys.stdin.readline().split(' '))
    c[xi - 1] += 1
    c[yi] -= 1

cur = 0
for i in range(0, m):
    cur += c[i]
    b[l[i]-1] += (cur*d[i])
    b[r[i]] -= (cur*d[i])

ret = []
cur = 0
for i in range(n):
    cur += b[i]
    ret.append(str(cur + a[i]))

sys.stdout.write(' '.join(ret) + '\n')
