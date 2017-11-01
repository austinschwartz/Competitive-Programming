def main(n, a):
    s = set(a)
    if len(s) < 3:
        return True
    if len(s) > 3:
        return False
    mi = min(a)
    ma = max(a)
    diff = (ma - mi) // 2
    for i in range(n):
        if a[i] == mi:
            a[i] += diff
        elif a[i] == ma:
            a[i] -= diff
    return len(set(a)) == 1

print("YES" if main(int(input()), list(map(int, input().split(' ')))) else "NO")
