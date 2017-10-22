from fractions import gcd
from functools import reduce

def main():
    n = int(input())
    a = sorted(list(map(int, input().split(' '))), key=lambda x: -x)
    return reduce(gcd, a) * n

print(main())
