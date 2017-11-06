def main():
    n = int(input())
    grid = []
    allones = 0
    for i in range(n):
        grid.append(int(input(), 2))
        allone = True
        for j in range(n):
            if grid[-1] & (1 << j) == 0:
                allone = False
                break
        if allone:
            allones += 1
    ret = 0
    for i in range(n):
        s = set()
        for j in range(n):
            if grid[i] & (1 << j) == 0:
                s.add(j)
        cur = 0
        for i in range(n):
            allone = True
            for j in range(n):
                if j not in s and (grid[i] & (1 << j)) == 0:
                    allone = False
                    break
                elif j in s and (grid[i] & (1 << j)) != 0:
                    allone = False
                    break
            if allone:
                cur += 1
        ret = max(ret, cur)
    return max(ret, allones)

print(main())

