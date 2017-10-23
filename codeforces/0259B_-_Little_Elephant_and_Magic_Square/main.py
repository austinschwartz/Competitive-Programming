def main():
    grid = []
    for i in range(3):
        grid.append(list(map(int, input().split(' '))))

    s = sum(grid[0]) + sum(grid[1]) + sum(grid[2])

    grid[0][0] = s//2 - sum(grid[0])
    grid[1][1] = s//2 - sum(grid[1])
    grid[2][2] = s//2 - sum(grid[2])

    for i in range(3):
        print(' '.join(list(map(str,grid[i]))))
main()
