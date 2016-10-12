(n, t) = map(int, raw_input().split(' '))
a = map(int, raw_input().split(' '))

visited = False
i = 0
while i < n:
    if i == t - 1:
        visited = True
        break
    if i >= len(a):
        break
    i += a[i]


if visited:
    print "YES"
else:
    print "NO"


