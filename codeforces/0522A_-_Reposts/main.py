m = {}

def dfs(par, i):
    global m
    ret = 1
    # leaf node
    if i not in m:
        return 1
    for j in m[i]:
        if j == par:
            continue
        ret = max(ret, dfs(i, j) + 1)
    return ret

def main():
    global m
    n = int(input())
    for i in range(n):
        (a, _, b) = map(lambda x: x.lower(), input().split(' '))
        if b in m:
            m[b].append(a)
        else:
            m[b] = [a]
    ret = 0
    for i in m:
        ret = max(ret, dfs(None, i))
    print(ret)

main()
