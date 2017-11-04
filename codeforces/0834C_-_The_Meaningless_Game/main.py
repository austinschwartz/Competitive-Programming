from math import pow
import sys

def main():
    n = int(sys.stdin.readline())
    for i in range(n):
        (a, b) = map(int, sys.stdin.readline().split(' '))
        c = round((a * b) ** (1. / 3))
        if c * c * c != a * b:
            sys.stdout.write('No\n')
            continue
        if a % c == 0 and b % c == 0:
            sys.stdout.write('Yes\n')
        else:
            sys.stdout.write('No\n')

main()
