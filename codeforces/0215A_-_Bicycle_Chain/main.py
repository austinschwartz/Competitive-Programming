import sys

def main():
    n = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split(' ')))
    m = int(sys.stdin.readline())
    b = list(map(int, sys.stdin.readline().split(' ')))
    m = 0
    for ai in a:
        for bj in b:
            if bj % ai == 0:
                m = max(m, bj // ai)
    
    s = set()
    for ai in a:
        for bj in b:
            if bj % ai == 0 and bj // ai == m:
                s.add((min(ai, bj), max(ai, bj)))

    sys.stdout.write('{}\n'.format(len(s)))


main()
