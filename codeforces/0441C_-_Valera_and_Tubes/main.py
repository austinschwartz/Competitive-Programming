import sys

def main():
    (n, m, k) = map(int, sys.stdin.readline().split(' '))
    l = []
    alt = False
    for i in range(n):
        if not alt:
            for j in range(m):
                l.append((i + 1, j + 1))
        else:
            for j in range(m - 1, -1, -1):
                l.append((i + 1, j + 1))
        alt ^= True
    length = (n * m) // k
    i = 0
    for j in range(1, k + 1):
        g = l[i:j*length]
        if j == k:
            g = l[i:]
        s = ' '.join(list(map(lambda x: ' '.join(map(str, x)), g)))
        sys.stdout.write('{} {}\n'.format(len(g), s))
        i = j * length

main()  
