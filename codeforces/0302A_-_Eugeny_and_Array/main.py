import sys

def main():
    (n, m) = map(int, sys.stdin.readline().split(' '))
    a = list(map(int, sys.stdin.readline().split(' ')))
    ones = 0
    negs = 0
    for ai in a:
        if ai == 1:
            ones += 1
        else:
            negs += 1
    for i in range(m):
        (l, r) = map(int, sys.stdin.readline().split(' '))
        count = r - l + 1
        if count % 2 != 0:
            sys.stdout.write("0\n")
        else:
            if ones >= count // 2 and negs >= count // 2:
                sys.stdout.write("1\n")
            else:
                sys.stdout.write("0\n")
main()
