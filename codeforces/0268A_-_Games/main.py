def main():
    n = int(input())
    h = []
    a = []
    for i in range(n):
        (hi, ai) = map(int, input().split(' '))
        h.append(hi)
        a.append(ai)
    ans = 0
    for i in range(n):
        for j in range(n):
            if i == j:
                continue
            if a[i] == h[j]:
                ans += 1
    return ans
print(main())

