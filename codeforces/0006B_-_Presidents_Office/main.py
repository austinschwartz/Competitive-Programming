n = 0
m = 0
r = 0
grid = []
pres = []

coords = [[1, 0], [-1, 0], [0, 1], [0, -1]]

def dfs(i, j):
    global n, m, r, grid, pres, coords
    grid[i][j] = '.'
    ret = set()
    for (ii, jj) in coords:
        ni = i + ii
        nj = j + jj
        if ni >= 0 and nj >= 0 and ni < n and nj < m:
            if grid[ni][nj] != '.' and grid[ni][nj] != r:
                ret.add(grid[ni][nj])
    return ret

def main():
    global n, m, r, grid, pres
    (n, m, r) = input().split(' ')
    n = int(n)
    m = int(m)
    for i in range(n):
        l = list(input())
        grid.append(l)
        for j, c in enumerate(l):
            if c == r:
                pres.append((i, j))
    ret = set()
    if len(pres) == 0:
        return 0
    for p in pres:
        (i, j) = p
        if i >= 0 and j >= 0 and i < n and j < m:
            if grid[i][j] == r:
                ret = ret.union(dfs(i, j))
    return len(ret)

print(main())

