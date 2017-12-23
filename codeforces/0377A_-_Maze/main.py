import sys
from collections import defaultdict

def main():
    sys.setrecursionlimit(1 << 30)
    g = []
    adj = defaultdict(set)
    vis = set()
    def valid(x, y):
        nonlocal n, m
        return x >= 0 and x < n and y >= 0 and y < m
    def bfs(x, y):
        nonlocal g, vis, adj
        q = []
        q.append((x, y))
        vis.add((x, y))
        s = 0
        while len(q) > 0:
            (x, y) = q.pop()
            s += 1
            for c in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                nx = c[0] + x
                ny = c[1] + y
                if valid(nx, ny) and (nx, ny) not in vis:
                    if g[nx][ny] == '.':
                        vis.add((nx, ny))
                        q.append((nx, ny))
        return s
    def bfs2(x, y):
        nonlocal g, vis, adj, count
        q = []
        q.append((x, y))
        vis.add((x, y))
        while len(q) > 0:
            (x, y) = q.pop()
            g[x][y] = 'o'
            count -= 1
            if count <= 0:
                return
            for c in [[-1, 0], [1, 0], [0, -1], [0, 1]]:
                nx = c[0] + x
                ny = c[1] + y
                if valid(nx, ny) and (nx, ny) not in vis:
                    if g[nx][ny] == '.':
                        vis.add((nx, ny))
                        q.append((nx, ny))
    (n, m, k) = map(int, input().split(' '))
    for i in range(n):
        g.append(list(input()))
    s = 0
    f = False
    l = None
    for i in range(n):
        if f:
            break
        for j in range(m):
            if g[i][j] == '.' and (i, j) not in vis:
                s = bfs(i, j)
                l = (i, j)
                f = True
                break
    vis = set()
    count = s - k
    bfs2(l[0], l[1])
    f = lambda i: 'X' if i == '.' else ('#' if i == '#' else '.')
    for row in g:
        print(''.join(list(map(f, row))))
main()

