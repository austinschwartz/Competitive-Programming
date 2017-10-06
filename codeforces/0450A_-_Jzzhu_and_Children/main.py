from collections import deque

(n, m) = map(int, input().split(' '))

a = list(map(int, input().split(' ')))
b = deque(list(range(n)))

i = 0
while len(b) > 0:
    cur = b.popleft()
    a[cur] = a[cur] - min(a[cur], m)
    if a[cur] > 0:
        b.append(cur)
    i = cur

print(i + 1)

