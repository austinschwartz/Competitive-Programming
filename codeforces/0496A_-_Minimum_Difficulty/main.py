def difficulty(a, n, x):
    ma = -1 * int(1e8)
    for i in range(1, n):
        v = 0
        if i == x:
            continue
        elif i - 1 == x:
            v = a[i] - a[i - 2]
        else:
            v = a[i] - a[i - 1]
        ma = max(ma, v)
    return ma

def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    mi = int(1e8)
    for i in range(1, n - 1):
        mi = min(difficulty(a, n, i), mi)
    print(mi)

main()
