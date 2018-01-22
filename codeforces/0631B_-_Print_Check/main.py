from sys import stdin, stdout

def main():
    (n, m, k) = map(int, stdin.readline().strip().split(' '))
    r = [0] * n
    c = [0] * m
    a = [0] * (k + 1)
    for i in range(1, k + 1):
        l, xi, a[i]  = map(int, stdin.readline().strip().split(' '))
        if l == 1:
            r[xi-1] = i
        else:
            c[xi-1] = i
    for i in range(n):
        l = []
        for j in range(m):
            l.append(str(a[max(r[i], c[j])]))
        print(' '.join(l))
main()
