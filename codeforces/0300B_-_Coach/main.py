from collections import defaultdict

par = []
size = []
scc = 0

def build(n):
    global par, size
    for i in range(n):
        par.append(i)
        size.append(1)
    return par

def find(i):
    global par
    if par[i] == i:
        return i
    par[i] = find(par[i])
    return par[i]

def union(a, b):
    global par, scc, size
    p = find(a)
    q = find(b)
    if p == q:
        return
    if size[q] > size[p]:
        temp = q
        q = p
        p = temp
    size[p] += size[q]
    size[q] = 0
    par[q] = par[p]
    scc += 1

def main():
    (n, m) = map(int, input().split(' '))
    par = build(n)
    for i in range(m):
        (a, b) = map(lambda i: int(i) - 1, input().split(' '))
        union(a, b)

    for x in range(5):
        for i in range(n):
            for j in range(i + 1, n):
                if size[i] % 3 == 1 and size[j] % 3 == 2:
                    union(i, j)
                elif size[j] % 3 == 1 and size[i] % 3 == 2:
                    union(i, j)
    for i in range(n):
        for j in range(i + 1, n):
            for k in range(j + 1, n):
                if size[i] % 3 == 1 and size[j] % 3 == 1 and size[k] % 3 == 1:
                    union(i, j)
                    union(i, k)

    # up to this point we've made teams of any size divisible by 3
    m = defaultdict(list)
    for i, p in enumerate(par):
        m[p].append(i + 1)

    for k in m:
        if len(m[k]) % 3 != 0 or len(m[k]) > 3:
            # if team size is > 3 then the only way of
            # making the players happy will break the 3
            # member per team limit, so return -1
            print(-1)
            return

    for k in m:
        print(' '.join(map(str, m[k])))
main()

