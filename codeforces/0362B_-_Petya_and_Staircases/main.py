def main(n, m, a):
    if a[0] == 1 or a[-1] == n:
        return "NO"
    for i in range(m - 2):
        if a[i] == a[i + 1] - 1 and a[i + 1] == a[i + 2] - 1:
            return "NO"
    return "YES"

(n, m) = map(int, input().split(' '))
if m == 0:
    print("YES")
else:
    print(main(n, m, sorted(list(map(int, input().split(' '))))))
