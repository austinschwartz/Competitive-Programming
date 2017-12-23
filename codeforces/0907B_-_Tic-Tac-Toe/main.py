def main():
    def get_cell(x, y):
        (r, c) = 0, 0
        if x <= 2:
            r = 0
        elif x <= 5:
            r = 1
        elif x <= 8:
            r = 2
        if y <= 2:
            c = 0
        elif y <= 5:
            c = 1
        elif y <= 8:
            c = 2
        return (r, c)
    def get_cells(grids, fx, fy):
        count = 0
        for i in range(3):
            for j in range(3):
                if grids[fx][fy][i][j] == '.':
                    grids[fx][fy][i][j] = '!'
                    count += 1
        return count
    g = []
    for i in range(11):
        l = ''.join(input().split())
        if len(l) > 0:
            g.append(list(l))
    grids = []
    for k in range(3):
        gg = []
        for j in range(3):
            ggg = []
            for i in range(3 * k, 3 * k + 3):
                ggg.append(g[i][j * 3:j * 3 + 3])
            gg.append(ggg)
        grids.append(gg)
    (x, y) = map(int, input().split(' '))
    x -= 1
    y -= 1
    (cx, cy) = get_cell(x, y)
    fx, fy = x, y
    while fx >= 3:
        fx -= 3
    while fy >= 3:
        fy -= 3
    count = get_cells(grids, fx, fy)
    if count == 0:
        for i in range(3):
            for j in range(3):
                get_cells(grids, i, j)
    ret = []
    for k in range(3):
        for j in range(3):
            x = []
            for i in range(3):
                x.append(''.join(grids[k][i][j]))
            ret.append(x)
        ret.append("")
    for thing in ret:
        print(' '.join(thing))
main()
