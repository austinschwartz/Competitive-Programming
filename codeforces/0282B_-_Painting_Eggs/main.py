import sys

def main():
    n = int(sys.stdin.readline())

    a_sum = 0
    b_sum = 0
    while n > 0:
        r = tuple(map(int, sys.stdin.readline().rstrip().split(' ')))
        if a_sum + r[0] <= b_sum + 500:
            sys.stdout.write('A')
            a_sum += r[0]
        else:
            sys.stdout.write('G')
            b_sum += r[1]
        n -= 1

main()
