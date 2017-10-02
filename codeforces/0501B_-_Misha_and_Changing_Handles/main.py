par = []
count = 0

def makeSet(n):
    global par
    for i in range(n + 1):
        par.append(i)

def find(a):
    global par
    if a == par[a]:
        return a
    par[a] = find(par[a])
    return par[a]

def union(a, b):
    global par
    par[find(a)] = find(b)

def main():
    global par, count
    n = int(input())
    makeSet(10000)
    m = {}
    og = set()
    for i in range(n):
        (old, new) = input().split(' ')
        if old not in m:
            m[old] = count
            count += 1
            og.add(old)
        if new not in m:
            m[new] = count
            count += 1
        union(m[old], m[new])
    rev = {}
    for i in m:
        rev[m[i]] = i
    print(len(og))
    for o in og:
        print(o, rev[find(m[o])])

main()
