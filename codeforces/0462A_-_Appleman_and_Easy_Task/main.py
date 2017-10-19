def main():
    n = int(input())
    grid = []
    for i in range(n):
        grid.append(list(input()))
    for i in range(n):
        for j in range(n):
            o = 0
            for (k, l) in [(1, 0), (0, 1), (-1, 0), (0, -1)]:
                if i + k >= 0 and i + k < n and j + l >= 0 and j + l < n:
                    if grid[i + k][j + l] == 'o':
                        o += 1
            if o % 2 != 0:
                return "NO"
    return "YES"

print(main())
                

