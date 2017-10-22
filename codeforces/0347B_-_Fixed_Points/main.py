def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    k = []
    f = 0
    for i, ai in enumerate(a):
        if ai != i:
            k.append((i, ai))
        else:
            f += 1
    k = sorted(k, key=lambda x: x[0])
    m = set()
    x = 1 if len(k) > 0 else 0
    for i, ai in k:
        if (i, ai) in m:
            x = 2
            break
        m.add((i, ai))
        m.add((ai, i))
    return f + x
print(main())
