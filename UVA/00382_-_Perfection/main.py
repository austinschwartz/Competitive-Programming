#!/usr/bin/env python3

import sys, math, re

def factorize(num):
    ret = set()
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            ret.add(i)
            ret.add(num // i)
    return ret

def main():
    lines = ' '.join(map(lambda x: x.strip(), sys.stdin.readlines())).rstrip()
    lst = list(map(int, re.split(r'\s+', lines)))

    perfects = set([6, 28, 496, 8128])
    sys.stdout.write("PERFECTION OUTPUT\n")
    for num in lst:
        if num == 0:
            sys.stdout.write("END OF OUTPUT\n")
            break
        if num in perfects:
            sys.stdout.write("{:>5}  PERFECT\n".format(num))
        else:
            if sum(factorize(num)) > num:
                sys.stdout.write("{:>5}  ABUNDANT\n".format(num))
            else:
                sys.stdout.write("{:>5}  DEFICIENT\n".format(num))

main()
