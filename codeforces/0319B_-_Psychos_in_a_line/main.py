from sys import stdin,stdout

def main(n, a):
    ans = 0
    top = 0
    t = [0 for i in range(n)]
    f = [0 for i in range(n)]
    for i in range(n - 1, -1, -1):
        tt = 0
        while top > 0 and a[t[top - 1]] < a[i]:
            top -= 1
            tt = max(tt + 1, f[t[top]])
            f[i] = tt
        t[top] = i
        top += 1
    return max(f)

stdout.write('{}\n'.format(main(int(stdin.readline().strip()), list(map(int, input().split(' '))))))
