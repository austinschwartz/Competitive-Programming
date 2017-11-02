def main(n, k, s):
    last = {}
    for i in range(n - 1, -1, -1):
        j = ord(s[i]) - ord('A')
        if j not in last:
            last[j] = i
    se = set()
    for i, c in enumerate(list(map(lambda i: ord(i) - ord('A'), s))):
        if c not in se:
            se.add(c)
        if len(se) > k:
            return "YES"
        if i == last[c]:
            se.remove(c)
    return "NO"

print(main(*list(map(int, input().split(' '))), input()))
