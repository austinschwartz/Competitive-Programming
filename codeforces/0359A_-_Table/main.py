def main():
    (n, m) = map(int, input().split(' '))
    good = []
    for i in range(n):
        line = list(map(int, input().split(' ')))
        for j in range(m):
            if line[j] == 1:
                good.append((i, j))
    ret = 4
    for (i, j) in good:
        if i == 0 or j == 0 or i == n - 1 or j == m - 1:
            ret = 2
    return ret
    
print(main())

