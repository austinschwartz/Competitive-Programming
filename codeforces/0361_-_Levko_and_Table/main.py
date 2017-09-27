import sys

(n, k) = map(int, sys.stdin.readline().split(' '))

for i in range(n):
    line = [0] * n
    line[i] = k
    sys.stdout.write('{}\n'.format(' '.join(map(str,line))))

