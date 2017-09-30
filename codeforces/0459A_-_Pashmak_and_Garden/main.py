def main():
    (x1, y1, x2, y2) = map(int, input().split(' '))
    if x1 == x2 and y1 == y2:
        return None
    a = max(x1, x2) - min(x1, x2)
    b = max(y1, y2) - min(y1, y2)
    c = max(a, b)
    s = set()
    s.add((min(x1, x2), min(y1, y2)))
    s.add((min(x1, x2) + c, min(y1, y2)))
    s.add((min(x1, x2), min(y1, y2) + c))
    s.add((min(x1, x2) + c, min(y1, y2) + c))
    ret = []
    for ss in s:
        if ss[0] == x1 and ss[1] == y1:
            continue
        if ss[0] == x2 and ss[1] == y2:
            continue
        ret.append(ss[0])
        ret.append(ss[1])
    return ret


ret = main()
print(' '.join(map(str,ret))) if len(ret) == 4 else print("-1")
