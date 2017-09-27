import sys

def main():
    n = int(sys.stdin.readline())
    if n % 2 != 0:
        sys.stdout.write("-1\n")
        return
    ret = list(range(1, n + 1))
    for i in range(0, n, 2):
        temp = ret[i]
        ret[i] = ret[i + 1]
        ret[i + 1] = temp

    sys.stdout.write("{}\n".format(' '.join(map(str,ret))))

main()
