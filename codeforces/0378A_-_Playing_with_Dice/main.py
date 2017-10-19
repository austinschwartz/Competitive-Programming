def main():
    (a, b) = map(int, input().split(' '))
    r = [0, 0, 0]
    for i in range(1, 7):
        aa = abs(i - a)
        bb = abs(i - b)
        if aa < bb:
            r[0] += 1
        elif aa > bb:
            r[2] += 1
        else:
            r[1] += 1
    print(' '.join(list(map(str, r))))

main()
