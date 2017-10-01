grid = []
def main():
    global grid, n, m
    (n, m) = map(int, input().split(' '))
    for i in range(n):
        grid.append(list(input()))
    for i in range(n):
        cur = 'B' if i % 2 == 0 else 'W'
        for j in range(m):
            cur = 'W' if cur == 'B' else 'B'
            if grid[i][j] == '-':
                continue
            grid[i][j] = cur

main()
for i in range(n):
    print(''.join(grid[i]))
