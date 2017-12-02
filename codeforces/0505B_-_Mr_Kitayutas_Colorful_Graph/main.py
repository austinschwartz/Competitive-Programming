from collections import defaultdict
from sys import stdin, stdout

par = defaultdict(list)

def build(n):
    global par
    for c in range(101):
        par[c] = []
        for i in range(n):
            par[c].append(i)
    return par

def find(c, i):
    global par
    if par[c][i] == i:
        return i
    par[c][i] = find(c, par[c][i])
    return par[c][i]

def union(a, b, c):
    global par
    p = find(c, a)
    q = find(c, b)
    if p == q:
        return
    par[c][q] = par[c][p]

def main():
    (n, m) = map(int, stdin.readline().strip().split(' '))
    par = build(n)
    max_c = 0
    for i in range(m):
        (a, b, c) = map(lambda i: int(i) - 1, stdin.readline().strip().split(' '))
        union(a, b, c)
        max_c = max(max_c, c)
    q = int(stdin.readline().strip())
    for i in range(q):
        (a, b) = map(lambda i: int(i) - 1, stdin.readline().strip().split(' '))
        count = 0
        for c in range(max_c + 1):
            p = find(c, a)
            q = find(c, b)
            if p == q:
                count += 1
        stdout.write('{}\n'.format(count))
main()
