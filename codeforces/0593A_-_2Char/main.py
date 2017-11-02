def main():
    letters = set()
    for c in range(ord('a'), ord('z') + 1):
        letters.add(chr(c))
    n = int(input())
    r = 0
    g = []
    for i in range(n):
        o = list(input())
        x = set(o)
        if len(x) <= 2:
            g.append((x, len(o)))
    for a in range(ord('a'), ord('z') + 1):
        for b in range(ord('a'), ord('z') + 1):
            ret = 0
            for gg in g:
                if len(gg[0].difference(set([chr(a), chr(b)]))) == 0:
                    ret += gg[1]
            r = max(ret, r)
    return r

print(main())
