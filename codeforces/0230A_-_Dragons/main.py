(s, n) = map(int, input().split(' '))

drags = []

for i in range(n):
    (x, y) = map(int, input().split(' '))
    drags.append((x, y))

drags.sort(key = lambda x: x[0])

dead = False
for drag in drags:
    if drag[0] >= s:
        dead = True
    else:
        s += drag[1]
if dead:
    print("NO")
else:
    print("YES")
