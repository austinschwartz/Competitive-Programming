import sys

def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    s = sum(a)

    i = 0
    while s > 0:
        if a[i] > 0:
            x = a[i]
            a[i] -= x
            s -= x
            if i < n - 1:
                sys.stdout.write('PRL' * x)
            else:
                sys.stdout.write('PLR' * x)
        if s > 0:
            i += 1
            sys.stdout.write('R')
    sys.stdout.write('\n')
        
main()
