grid = []
for i in range(4):
    grid.append(list(input()))

def valid(r, c):
    if r < 0 or c < 0 or r > 3 or c > 3:
        return False
    return True

def count(r, c):
    # Top
    if valid(r - 1, c) and grid[r - 1][c] == '#':
        # Left
        if valid(r, c - 1) and grid[r][c - 1] == '#' and \
                valid(r - 1, c - 1) and grid[r - 1][c - 1] == '#':
                    return True
        # Right
        if valid(r, c + 1) and grid[r][c + 1] == '#' and \
                valid(r - 1, c + 1) and grid[r - 1][c + 1] == '#':
                    return True
    # Bottom
    if valid(r + 1, c) and grid[r + 1][c] == '#':
        # Left
        if valid(r, c - 1) and grid[r][c - 1] == '#' and \
                valid(r + 1, c - 1) and grid[r + 1][c - 1] == '#':
                    return True
        # Right
        if valid(r, c + 1) and grid[r][c + 1] == '#' and \
                valid(r + 1, c + 1) and grid[r + 1][c + 1] == '#':
                    return True

    return False

def solve():
    for r in range(4):
        for c in range(4):
            if count(r, c):
                return "YES"
    return "NO"

def flip():
    for i in range(4):
        for j in range(4):
            grid[i][j] = '#' if grid[i][j] == '.' else '.'

ans = solve()
if ans == "NO":
    flip()
    ans = solve()
print(ans)
