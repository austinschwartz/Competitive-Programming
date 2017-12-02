from sys import stdin, stdout
from collections import defaultdict

MAXN = 1001
T = [[0 for i in range(MAXN)] for j in range(MAXN)]

def main():
    (n, m, k) = map(int, stdin.readline().strip().split(' '))
    for i in range(n):
        l = list(map(int, stdin.readline().strip().split(' ')))
        for j in range(m):
            T[i][j] = l[j]
    l = defaultdict(
    for i in range(k):
        (s, x, y) = stdin.readline().strip().split(' ')
        x = int(x) - 1
        y = int(y) - 1
        print(s, x, y)

main()

