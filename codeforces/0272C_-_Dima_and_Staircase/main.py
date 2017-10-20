import sys

def main():
    n = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split(' ')))
    m = int(sys.stdin.readline())
    (w1, h1) = (0, 0)
    H = 0
    for i in range(m):
        (w2, h2) = map(int, sys.stdin.readline().split(' '))
        H = max(H + h1, a[w2 - 1])
        sys.stdout.write('{}\n'.format(str(H)))
        (w1, h1) = (w2, h2)

main()
