(n, m) = map(int, input().split(' '))

parent = {}
for i in range(1, n + 1):
    parent["e" + str(i)] = "e" + str(i)

for j in range(1, m + 1):
    parent["l" + str(j)] = "l" + str(j)

def find(i):
    if parent[i] == i:
        return i
    parent[i] = find(parent[i])
    return parent[i]

def union(i, j):
    parent[find(i)] = find(j)

for i in range(1, n + 1):
    line = input()
    if line != '0':
        for j in line.split(' ')[1:]:
            union("e" + str(i), "l" + j)

#compress paths
for i in range(1, n + 1):
    find("e" + str(i))

for j in range(1, m + 1):
    find("l" + str(j))

m = {}
for i in range(1, n + 1):
    x = "e" + str(i)
    p = parent[x]
    if p in m:
        m[p] += 1
    else:
        m[p] = 0

numofzerokeys = 0
for i in range(1, n + 1):
    if "e" + str(i) in m and m["e" + str(i)] == 0:
        numofzerokeys += 1

if numofzerokeys == n:
    print(n)
else:
    print(len(m) - 1)
