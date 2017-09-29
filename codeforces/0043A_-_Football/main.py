import sys

n = int(sys.stdin.readline())

d = {}
m = 0
for i in range(n):
    s = sys.stdin.readline().strip()
    if s in d:
        d[s] += 1
    else:
        d[s] = 0
    m = s

for i in d:
    if d[i] > d[m]:
        m = i

sys.stdout.write('{}\n'.format(m))
