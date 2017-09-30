import sys

def main():
    s = sys.stdin.readline().strip()
    n = len(s)
    l = []
    r = []
    for i in range(len(s)):
        if s[i] == 'l':
            l.append(i + 1)
        else:
            r = [(i + 1)] + r

    for i in reversed(r):
        sys.stdout.write('{}\n'.format(i))
    for i in reversed(l):
        sys.stdout.write('{}\n'.format(i))

main()
