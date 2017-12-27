def main():
    from functools import cmp_to_key
    def cmp(i, j):
        nonlocal a
        if a[i] == a[j]:
            return j - i
        return a[i] - a[j]
    n = int(input())
    a = list(map(int, input().split(' ')))
    b = sorted(list(range(9)), key=cmp_to_key(cmp))
    d = n // a[b[0]]
    s = list(str(b[0] + 1) * d)
    p = n - (d * a[b[0]])
    for i in range(d):
        x = a[ord(s[i]) - 1 - ord('0')]
        for j in range(8, -1, -1):
            if x + p >= a[j]:
                p -= (a[j] - (a[ord(s[i]) - 1 - ord('0')]))
                s[i] = chr(j + ord('1'))
                break
    if len(s) == 0:
        return "-1"
    return ''.join(s)
print(main())
