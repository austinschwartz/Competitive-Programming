n = int(input())
par = [-1 for i in range(2001)]
for i in range(n):
    p = int(input())
    par[i] = p
    if p != -1:
        par[i] -= 1


top = 0
for i in range(2001):
    if par[i] == -1:
        continue
    depth = 0
    j = par[i]
    while j != -1:
        depth += 1
        j = par[j]
    top = max(top, depth)

print(top + 1)
