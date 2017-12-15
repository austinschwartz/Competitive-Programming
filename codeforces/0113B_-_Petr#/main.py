from sys import stdin, stdout
def main():
    BASE = 37
    MOD = 1e7 + 7
    s = stdin.readline().strip()
    n = len(s)
    begin = stdin.readline().strip()
    end = stdin.readline().strip()
    b = set()
    for i in range(0, n):
        k = 0
        while k + i < n and k < len(begin) and s[k + i] == begin[k]:
            k += 1
        if k == len(begin):
            b.add(i)
    e = set()
    for i in range(0, n):
        k = 0
        while k + i < n and k < len(end) and s[k + i] == end[k]:
            k += 1
        if k == len(end):
            e.add(i + k - 1)

    h = [ord(s[0])]
    p = [1]
    for i in range(1, n):
        h.append(int(((h[i - 1] * BASE) % MOD + ord(s[i])) % MOD))
        p.append(int((p[i - 1] * BASE) % MOD))
    se = set()
    for i in b:
        for j in e:
            if j < i + max(len(begin), len(end)) - 1:
                continue
            if i == 0:
                se.add(h[j])
            else:
                se.add((h[j] - int(((h[i - 1] * p[j - i + 1]) % MOD))) % MOD)
    return len(se)

stdout.write('{}\n'.format(main()))

