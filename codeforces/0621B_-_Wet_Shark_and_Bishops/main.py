import sys
from collections import defaultdict

def main():
    n = int(sys.stdin.readline())
    m1 = defaultdict(int)
    m2 = defaultdict(int)
    ans = 0
    for i in range(n):
        (xi, yi) = map(int, sys.stdin.readline().split(' '))
        if (xi - yi) in m1:
            ans += m1[xi - yi]
        m1[xi - yi] += 1 
        if xi + yi in m2:
            ans += m2[xi + yi]
        m2[xi + yi] += 1 
    return ans

sys.stdout.write('{}\n'.format(main()))
