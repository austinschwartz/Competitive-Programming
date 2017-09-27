import sys

n = int(sys.stdin.readline())

a = 0
b = 0
for i in range(n):
    (aa, bb) = map(int, sys.stdin.readline().split(' '))
    a += aa
    b += bb

sys.stdout.write("{}\n".format(min(abs(a), n - abs(a)) + min(abs(b), n - abs(b))))

