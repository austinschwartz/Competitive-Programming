def main():
    n = int(input())
    s = list(map(int,list(input())))
    l = sorted(s[:n])
    r = sorted(s[n:])
    t1 = True
    for i in range(n):
        if r[i] >= l[i]:
            t1 = False
    t2 = True
    for i in range(n):
        if l[i] >= r[i]:
            t2 = False

    return t1 or t2

print("YES" if main() else "NO")
