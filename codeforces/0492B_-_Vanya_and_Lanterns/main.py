import sys

def main():
    (n, l) = map(int, sys.stdin.readline().split(' '))
    a = sorted(list(map(int, sys.stdin.readline().split(' '))))
    m = a[0] * 2
    m = max(m, (l - a[n-1]) * 2)
    for i in range(1, n):
        m = max(m, a[i] - a[i-1])
    sys.stdout.write('{:0.10f}\n'.format(float(m) / 2.0))

main()

