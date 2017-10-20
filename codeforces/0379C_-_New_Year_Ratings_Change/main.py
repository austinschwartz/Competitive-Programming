import sys

def main():
    n = int(sys.stdin.readline())
    a = list(map(int, sys.stdin.readline().split(' ')))
    l = sorted(range(n),key=lambda i: a[i])
    cur = a[l[0]]
    s = set([cur])
    for i in range(1, n):
        if a[l[i]] == cur or a[l[i]] in s:
            a[l[i]] = cur + 1
        cur = a[l[i]]
        s.add(cur)
    sys.stdout.write('{}\n'.format(' '.join(list(map(lambda i: str(i), a)))))

main()

