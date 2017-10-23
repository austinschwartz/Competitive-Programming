def main():
    l = []
    c = []
    for i in range(4):
        l.append(input()[2:])
        c.append(len(l[-1]))
    g = [False] * 4
    for i in range(4):
        longer = 0
        shorter = 0
        for j in range(4):
            if i == j:
                continue
            if c[i] <= c[j] // 2:
                shorter += 1
            if c[i] >= c[j] * 2:
                longer += 1
        g[i] = (longer == 3) | (shorter == 3)
    if len(list(filter(lambda i: i, g))) > 1:
        return 'C'
    for i in range(4):
        if g[i]:
            return ['A', 'B', 'C', 'D'][i]
    return "C"
print(main())

