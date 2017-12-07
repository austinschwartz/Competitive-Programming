from itertools import permutations
from sys import stdin, stdout

def main(n):
    for x in range(0, 1000000):
        y = (n - 4 * x) // 7
        if y < 0:
            break
        if ((4 * x) + (7 * y) == n) and x >= 0 and y >= 0:
            l = []
            for i in range(x):
                l.append(4)
            for j in range(int(y)):
                l.append(7)
            stdout.write(''.join(list(map(str,l))) + '\n')
            return
    stdout.write('-1\n')

main(int(stdin.readline().strip()))
