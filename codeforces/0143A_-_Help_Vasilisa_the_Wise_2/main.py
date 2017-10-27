import sys

def main():
    (r1, r2) = map(int, sys.stdin.readline().split(' '))
    (c1, c2) = map(int, sys.stdin.readline().split(' '))
    (d1, d2) = map(int, sys.stdin.readline().split(' '))
    for i in range(1, 10):
        for j in range(1, 10):
            for k in range(1, 10):
                for l in range(1, 10):
                    if i + j == r1 and k + l == r2 and i + k == c1 and j + l == c2 and i + l == d1 and j + k == d2 and i != j and j != k and i != k and k != l and l != j and i != l:
                        return [[i, j], [k, l]]
    return [[-1, -1], [-1, -1]]


l = main()
if l[0][0] == -1:
    sys.stdout.write("-1\n")
else:
    for i in range(len(l)):
        sys.stdout.write("{}\n".format((' '.join(list(map(str, l[i]))))))
