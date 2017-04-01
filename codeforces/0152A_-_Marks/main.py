(n, m) = map(int, input().split(' '))

grid = []

for i in range(n):
    grid.append(list(int(x) for x in input()))

best = set()

ma = [0 for j in range(m)]

for j in range(m):
    for i in range(n):
        ma[j] = max(grid[i][j], ma[j])

for j in range(m):
    for i in range(n):
        if grid[i][j] == ma[j]:
            best.add(i)

print(len(best))
