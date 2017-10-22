grid = []
n = 0

def main():
    global grid, n
    def clear(i, j):
        if i - 1 < 0 or i + 1 >= n or j < 0 or j + 2 >= n:
            return False
        if grid[i][j] == '.' or grid[i][j + 1] == '.' or grid[i][j + 2] == '.':
            return False
        grid[i][j] = '.'
        grid[i][j + 1] = '.'
        grid[i][j + 2] = '.'
        if grid[i + 1][j + 1] == '.' or grid[i - 1][j + 1] == '.':
            return False
        grid[i + 1][j + 1] = '.'
        grid[i - 1][j + 1] = '.'
        return True

    n = int(input())
    for i in range(n):
        grid.append(list(input()))
    for j in range(n):
        for i in range(n):
            if grid[i][j] == '#':
                if not clear(i, j):
                    return False
    for i in range(n):
        for j in range(n):
            if grid[i][j] == '#':
                return False
    return True


print("YES" if main() else "NO")
