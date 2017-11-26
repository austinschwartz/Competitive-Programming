from math import floor

def main(xx, yy):
    if xx == 0 and yy == 0:
        return 0
    if xx == 1 and yy == 0:
        return 0
    x = 0
    y = 0
    i = 0
    g = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    while not (x == xx and y == yy):
        prev_x = x
        prev_y = y
        x += (int(floor(i / 2) + 1) * g[i % 4][0])
        y += (int(floor(i / 2) + 1) * g[i % 4][1])
        i += 1
        if xx >= x and xx <= prev_x and yy >= y and yy <= prev_y:
            return i - 1
        if xx <= x and xx >= prev_x and yy <= y and yy >= prev_y:
            return i - 1
    return i - 1

print(main(*list(map(int, input().split(' ')))))
