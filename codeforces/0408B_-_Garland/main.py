def main():
    from collections import Counter
    n = Counter(list(input()))
    m = Counter(list(input()))
    ret = 0
    s = set()
    for c in m:
        if c in n and n[c] >= m[c]:
            s.add(c)
            ret += m[c]
            n[c] -= m[c]
            m[c] = 0
        elif c in n and n[c] < m[c]:
            s.add(c)
            ret += n[c]
            m[c] -= n[c]
            n[c] -= n[c]
        elif c not in n:
            return -1
    for c in m:
        if c in s:
            continue
        if c in n and m[c] > 0 and n[c] >= 0:
            ret += 1
            m[c] = 0
    return ret if ret > 0 else -1
print(main())
