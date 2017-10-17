def f(s):
    if isinstance(s, int):
        return s
    op = s[0]
    a = f(s[1])
    b = f(s[2])
    if op == '*':
        return a * b
    else:
        return a + b

def main():
    a = int(input())
    b = int(input())
    c = int(input())
    ans = 0
    for s1 in ['+', '*']:
        for s2 in ['+', '*']:
            for brack in [0, 1, 2]:
                cur = 0
                if brack == 0:
                    cur = f((s2, c, (s1, a, b)))
                elif brack == 1:
                    cur = f((s1, a, (s2, b, c)))
                else:
                    if s1 == '*':
                        cur = f((s2, (s1, a, b), c))
                    else:
                        cur = f((s1, (s2, b, c), a))
                ans = max(ans, cur)
    return ans

print(main())

