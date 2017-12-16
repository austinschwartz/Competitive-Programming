def main():
    (n, k) = map(int, input().split(' '))
    s = list(input())
    G = s.index('G')
    T = s.index('T')
    v = set()
    for j in range(G, n, k):
        if s[j] == '#':
            break
        v.add(j)
    for j in range(G, -1, -k):
        if s[j] == '#':
            break
        v.add(j)
    return "YES" if T in v else "NO"

print(main())
