import sys

def main(n, m, k):
    def f(x, n, m, k):
        return sum([min(n, (x - 1) // i) for i in range(1, m + 1)]) < k
    low = 1
    high = n * m + 1
    while low < high:
        mid = low + (high - low)//2
        if f(mid, n, m, k):
            low = mid + 1
        else:
            high = mid
    return low - 1

sys.stdout.write('{}'.format(main(*list(map(int, sys.stdin.readline().split(' '))))))
