def main():
    (n, v) = map(int, input().split(' '))
    r = []
    for i in range(n):
        if v > min(list(map(int, input().split(' ')[1:]))):
            r.append(str(i + 1))
    print(len(r))
    if len(r) > 0:
        print(' '.join(r))
main()
