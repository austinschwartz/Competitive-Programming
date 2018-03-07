def main():
    def f(s, n, p, o):
        if n == 2 and s[0] == s[1]:
            return False
        for i in range(0, n - 1):
            if ord(s[i]) - ord('a') >= p:
                return False
            if s[i] == s[i + 1]:
                return False
        for i in range(0, n - 2):
            if s[i] == s[i + 2]:
                return False
        if ''.join(o) == ''.join(s):
            return False
        return True
    (n, p) = map(int, input().split(' '))
    s = list(input())
    original = [x for x in s]
    if n == 1:
        if ord(s[0]) - ord('a') >= p - 1:
            return "NO"
        else:
            return chr(ord(s[0]) + 1)
    i = n - 1
    l = chr((ord('a') + p - 1))
    carry = 0
    while i >= 0:
        if s[i] == l:
            s[i] = 'a'
            j = i - 1
            while s[j] == l:
                s[j] = 'a'
                j -= 1
            if j >= 0:
                s[j] = chr(ord(s[j]) + 1)
            else:
                break
        else:
            s[i] = chr(ord(s[i]) + 1)
        print(s)
        if s[i] != s[i - 1] and s[i - 1] != s[i - 2]:
            if f(s, n, p, original):
                break
    if f(s, n, p, original):
        return ''.join(s)
    return "NO"
print(main())
