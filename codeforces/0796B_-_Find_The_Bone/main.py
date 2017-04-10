(n, m, k) = map(int, input().split(' '))
hs = map(int, input().split(' '))

holes = set(hs)

pos = 1

for i in range(k):
    if pos in holes:
        break
    (u, v) = map(int, input().split(' '))
    if pos == u:
        pos = v
    elif pos == v:
        pos = u

print(pos)

