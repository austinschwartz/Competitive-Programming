def main():
    (x, y, a, b) = map(int, input().split(' '))
    l = []
    for c in range(a, x + 1):
        for d in range(b, y + 1):
            if c > d:
                l.append((c, d))
    print(len(l))
    for ll in l:
        print("{} {}".format(*ll))
main()

