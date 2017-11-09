import sys

def main():
    (n, m) = map(int, sys.stdin.readline().strip().split(' '))
    s = list(input())
    k = 0
    for i in range(n - 1):
        if s[i] == '.' and s[i + 1] == '.':
            k += 1
    for j in range(m):
        (xi, ci) = sys.stdin.readline().strip().split(" ")
        xi = int(xi) - 1
        prev = s[xi]
        s[xi] = ci
        if prev == '.' and ci != '.':
            if xi != 0 and s[xi - 1] == '.':
                k -= 1
            if xi != n - 1 and s[xi + 1] == '.':
                k -= 1
        elif prev != '.' and ci == '.':
            if xi != 0 and s[xi - 1] == '.':
                k += 1
            if xi != n - 1 and s[xi + 1] == '.':
                k += 1
        sys.stdout.write("{}\n".format(k))

main()
