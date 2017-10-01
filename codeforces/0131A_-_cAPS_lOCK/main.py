def passes(s):
    upper = 0
    n = len(s)
    for c in list(s):
        if c <= 'Z' and c >= 'A':
            upper += 1
    if upper == n:
        return True
    if upper == n - 1 and not (s[0] <= 'Z' and s[0] >= 'A'):
        return True
    return False

def main():
    s = input()
    if passes(s):
        first_lower = True
        if s[0] <= 'Z' and s[0] >= 'A':
            first_lower = False
        s = list(s.lower())
        if first_lower:
            s[0] = chr(ord(s[0]) + ord('A') - ord('a'))
        s = ''.join(s)
    return s

print(main())
