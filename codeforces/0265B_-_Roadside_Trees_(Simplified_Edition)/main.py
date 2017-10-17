def main():
    n = int(input())
    a = []
    for i in range(n):
        a.append(int(input()))
    if n == 1:
        return a[0] + 1
    h = 0
    ans = 0
    for i in range(n):
        assert(a[i] >= h)

        # walk up if needed
        if a[i] > h:
            ans += (a[i] - h)
            h = a[i]

        # eat
        ans += 1

        if i < n - 1:
            # walk down if needed
            if a[i + 1] < h:
                dif = (h - a[i + 1])
                ans += dif
                h -= dif
            # jump
            ans += 1
    return ans

print(main())
