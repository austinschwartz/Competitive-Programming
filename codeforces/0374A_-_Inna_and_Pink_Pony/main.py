def main():
    (n, m, x, y, a, b) = map(int, input().split(' '))
    mi = int(1e9)
    for x2, y2 in [(1, m), (n, 1), (n, m), (1, 1)]:
        if x == x2 and y == y2:
            return 0
        if abs(x2 - x) % a != 0 or abs(y2 - y) % b != 0:
            continue
        o = abs(x2 - x) // a
        p = abs(y2 - y) // b
        if not o % 2 == p % 2:
            continue
        mi = min(mi, max(o, p))
    if int(mi) == int(1e9) or n <= a or m <= b:
        return "Poor Inna and pony!"
    return int(mi)
print(main())
