import sys

def main():
    def p(h, m):
        return "{:02d}".format(h) == "{:02d}".format(m)[::-1]
    (h, m) = map(int, input().split(":"))
    m += 1
    if m >= 60:
        h += 1
        m = 0
    if h >= 24:
        h = 0

    while not p(h, m):
        m += 1
        if m >= 60:
            h += 1
            m = 0
        if h >= 24:
            h = 0
    sys.stdout.write("{:02d}:{:02d}\n".format(h, m))
main()
