def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    ret = 0
    l = [0] * n # l[i] = # of spots < i that will be filled
    r = [0] * n # r[i] = # of spots > i that will be filled
    for i in range(1, n):
        if a[i] >= a[i - 1]:
            l[i] = l[i - 1] + 1
        else:
            l[i] = 0

    for i in range(n - 2, -1, -1):
        if a[i] >= a[i + 1]:
            r[i] = r[i + 1] + 1
        else:
            r[i] = 0

    for i in range(n):
        ret = max(ret, l[i] + r[i] + 1)
    return ret
print(main())

