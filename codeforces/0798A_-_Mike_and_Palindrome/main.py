def main(s):
    n = len(s)
    def pal(s):
        nonlocal n
        for i in range(0, n // 2 + 1):
            if s[i] != s[n - i - 1]:
                return False
        return True
    for i in range(n):
        for j in range(ord('a'), ord('z') + 1):
            if j != ord(s[i]):
                temp = s[i]
                s[i] = chr(j)
                if pal(s):
                    return True
                s[i] = temp
    return False

print("YES" if main(list(input())) else "NO")
