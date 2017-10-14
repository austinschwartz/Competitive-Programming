n = 0
m = 0

def is_valid(i, j):
    global n, m
    if i < 0 or j < 0 or i >= n or j >= m:
        return False
    return True

def h(g):
    global n, m
    s = ""
    for i in range(n):
        for j in range(m):
            s += g[i][j]
    return s

coords = [[0, 1], [1, 0], [0, -1], [-1, 0]]

def main():
    global n, m, coords
    (n, m) = map(int, input().split(' '))
    grid = []
    for i in range(n):
        grid.append(list(input()))
    eaten = 0
    prev_hash = "x"
    grid_hash = h(grid)
    while grid_hash != prev_hash:
        prev_hash = grid_hash
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 'P':
                    adj_wolves = 0
                    wi = -1
                    wj = -1
                    for coord in coords:
                        ni = i + coord[0]
                        nj = j + coord[1]
                        if is_valid(ni, nj) and grid[ni][nj] == 'W':
                            adj_wolves += 1
                            wi = ni
                            wj = nj
                    if adj_wolves == 1:
                        grid[i][j] = '.'
                        grid[wi][wj] = '.'
                        eaten += 1
        grid_hash = h(grid)
    return eaten

print(main())
