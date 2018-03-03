def main():
    (n, d) = map(int, input().split(' '))
    l = list(input())
    c = {}
    c[1] = 0
    c[0] = int(1e9)
    for i in range(len(l)):
        if l[i] == '0':
            c[i + 1] = int(1e9)
    def f(x):
        nonlocal c, d, l
        if x in c:
            return c[x]
        ret = int(1e9)
        if x > n or x < 0:
            c[n] = ret
            return ret
        if l[x - 1] == '0':
            return ret
        for i in range(1, d + 1):
            ret = min(ret, 1 + f(x - i))
        c[x] = ret
        return ret
    x = f(n)
    return x if x != int(1e9) else -1
print(main())

        
