def main():
    input()
    mi = int(1e8)
    for _ in list(map(int, input().split(' '))):
        m = list(map(int, input().split(' ')))
        mi = min(mi, len(m) * 15 + sum(list(map(lambda i: i*5, m))))
    return mi

print(main())
