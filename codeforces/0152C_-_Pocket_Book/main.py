MOD = int(1e9 + 7)
def main():
    global mod
    (n, m) = map(int, input().split(' '))
    l = [set() for i in range(m)]
    for i in range(n):
        for j, c in enumerate(input()):
            l[j].add(c)
    ret = 1
    for i, s in enumerate(l):
        ret = (ret * len(s)) % MOD
    return ret   

print(main())
