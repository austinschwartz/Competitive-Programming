def main():
    def right(p):
        def dist(x1, y1, x2, y2):
            from math import sqrt
            return sqrt(((x2 - x1) ** 2) + ((y2 - y1) ** 2))
        d = sorted([dist(p[0], p[1], p[2], p[3]),
                    dist(p[2], p[3], p[4], p[5]),
                    dist(p[4], p[5], p[0], p[1])])
        from math import isclose
        if p[0] == p[2] and p[1] == p[3]:
            return False
        if p[0] == p[4] and p[1] == p[5]:
            return False
        if p[2] == p[4] and p[3] == p[5]:
            return False
        return isclose(d[0] * d[0] + d[1] * d[1], d[2] * d[2], rel_tol=1e-6)
    p = list(map(int, input().split(' ')))
    if right(p):
        return "RIGHT"
    for i in range(6):
        for j in set([-1, 1]):
            p[i] += j
            if right(p):
                return "ALMOST"
            p[i] -= j
    return "NEITHER"

print(main())
