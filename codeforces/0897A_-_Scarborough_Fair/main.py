from sys import stdin, stdout

def main():
    (n, m) = map(int, stdin.readline().strip().split(' '))
    s = list(stdin.readline().strip())
    for i in range(m):
        (l, r, c1, c2) = stdin.readline().strip().split(' ')
        l = int(l) - 1
        r = int(r) - 1
        for j in range(l, r + 1):
            if s[j] == c1:
                s[j] = c2
    print(''.join(s))

main()

