from itertools import permutations
from collections import deque

def inp():
    g = []
    for i in range(5):
        g.append(list(map(int,input().split(' '))))
    return g

def cost(g, q):
    ret = 0
    while len(q) > 0:
        for i in range(0, len(q) - 1, 2):
            ret += g[q[i]][q[i + 1]]
            ret += g[q[i + 1]][q[i]]
        q.popleft()
    return ret

def main():
    g = inp()
    m = 0   
    for lst in permutations(range(5)):
        m = max(m, cost(g, deque(lst)))
    return m

print(main())
