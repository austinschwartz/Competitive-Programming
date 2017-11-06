def main(s):
    n = len(s)
    se = set()
    for i in range(n):
        se.add(s[i:] + s[:i])
    return len(se)

print(main(input()))
