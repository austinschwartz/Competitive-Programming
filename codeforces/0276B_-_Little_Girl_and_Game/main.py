from collections import defaultdict

def main():
    s = input()
    m = defaultdict(int)
    for c in list(s):
        m[c] += 1
    e = 0
    o = 0
    for k in m:
        if m[k] % 2 == 0:
            e += m[k]
        else:
            o += m[k]
    winner = 0
    while e + o > 0:
        if o == 1:
            break
        if e > 0:
            e -= 1
        else:
            o -= 1
        winner ^= 1
    return "First" if winner == 0 else "Second"

print(main())
