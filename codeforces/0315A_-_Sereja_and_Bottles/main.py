n = int(input())

lst = []
for i in range(n):
    (a, b) = map(int, input().split(' '))
    lst.append((a, b))

ret = 0
for i in range(n):
    (a, b) = lst[i]
    for j in range(n):
        if i == j:
            continue
        (aa, bb) = lst[j]
        if (bb == a):
            ret += 1
            break

print(n - ret)
