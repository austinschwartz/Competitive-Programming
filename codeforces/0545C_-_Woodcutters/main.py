import sys

def main():
    n = int(sys.stdin.readline())
    x = []
    h = []
    for i in range(n):
        (xi, hi) = map(int, sys.stdin.readline().split(' '))
        x.append(xi)
        h.append(hi)

    seg = x[0]
    t = 1
    for i in range(1, n):
        # try to fall left
        if (x[i] - h[i]) > seg:
            seg = x[i]
            t += 1
        elif i == n - 1 or x[i] + h[i] < x[i + 1]:
            # falling right
            seg = x[i] + h[i]
            t += 1
        else:
            seg = x[i]
    return t

sys.stdout.write("{}\n".format(main()))
