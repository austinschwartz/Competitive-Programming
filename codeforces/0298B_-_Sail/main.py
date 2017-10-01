
def main():
    (t, sx, sy, ex, ey) = map(int, input().split(' '))
    if sx == ex and sy == ey:
        return 0
    t = 0
    for c in list(input()):
        if sx == ex and sy == ey:
            return t
        if c == 'S':
            if ey < sy:
                sy -= 1
        elif c == 'N':
            if ey > sy:
                sy += 1
        elif c == 'E':
            if ex > sx:
                sx += 1
        elif c == 'W':
            if ex < sx:
                sx -= 1
        t += 1
    if sx == ex and sy == ey:
        return t
    return -1

print(main())
