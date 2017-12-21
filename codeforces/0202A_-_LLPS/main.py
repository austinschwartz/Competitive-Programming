def main():
    from collections import defaultdict
    m = defaultdict(int)
    for c in input():
        m[c] += 1
    i = sorted(list(m.keys()))[-1]
    return i * m[i]
print(main())
