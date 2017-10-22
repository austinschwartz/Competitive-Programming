def main():
    (n, m) = map(int, input().split(' '))
    c = [0 for i in range(n)]
    e = []
    for i in range(m):
        (ai, bi) = map(int, input().split(' '))
        c[ai - 1] += 1
        c[bi - 1] += 1
        e.append((ai - 1, bi - 1))
    center = None
    for i, ci in enumerate(c):
        if ci == 0:
            center = i
            break
    assert(center != None)
    print(n - 1)
    for i in range(n):
        if i == center:
            continue
        print("{} {}".format(i + 1, center + 1))
main()

