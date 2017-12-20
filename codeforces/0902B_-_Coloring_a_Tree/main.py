from sys import stdin, stdout
def main():
    def dfs(i, par):
        nonlocal adj, c
        ret = 0
        if par == -1 or c[i - 1] != c[par - 1]:
            ret += 1
        for j in adj[i]:
            if j != par:
                ret += dfs(j, i)
        return ret
    from collections import defaultdict
    n = int(stdin.readline().strip())
    adj = defaultdict(list)
    p = list(map(int, stdin.readline().strip().split(' ')))
    for i, pi in enumerate(p):
        adj[pi].append(i + 2)
        adj[i + 2].append(pi)
    c = list(map(int, stdin.readline().strip().split(' ')))
    return dfs(1, -1)

stdout.write('{}\n'.format(main()))
