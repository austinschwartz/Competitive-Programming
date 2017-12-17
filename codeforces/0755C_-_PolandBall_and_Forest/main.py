def main():
    MAXN = int(1e4 + 7)
    par = []
    for i in range(MAXN):
        par.append(i)
    def find(i):
        if i == par[i]:
            return i
        return find(par[i])
    def union(i, j):
        p = find(i)
        q = find(j)
        if p == q:
            return
        par[p] = q
    n = int(input())
    p = list(map(int, input().split(' ')))
    for i in range(n):
        union(i, p[i] - 1)
    s = set()
    for i in range(n):
        s.add(find(i))
    print(len(s))
main()

