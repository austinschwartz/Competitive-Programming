import sys

n = int(sys.stdin.readline())

for i in range(2*n + 1):
    line = []
    for j in range(2 * n + 1):
        x = ' '
        line.append(x)
    j = n
    if j == n and i == n:
        line[j] = n
    elif i <= n:
        line[j] = (n + i) % n
    else:
        line[j] = (n - i) % n
    for j in range(n, -1, -1):
        if line[j + 1] != ' ' and line[j + 1] > 0:
            line[j] = line[j + 1] - 1
    for j in range(n + 1, 2 * n + 1, 1):
        if line[j - 1] != ' ' and line[j - 1] > 0:
            line[j] = line[j - 1] - 1

    sys.stdout.write('{}\n'.format(' '.join(map(str,line)).rstrip()))
