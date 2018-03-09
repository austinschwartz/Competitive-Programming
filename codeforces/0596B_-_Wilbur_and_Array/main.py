def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    x = 0
    ans = 0
    for i in range(n):
        if (a[i] - x) != 0:
            prev_x = x
            x += (a[i] - x)
            ans += abs(x - prev_x)
        #print(a[i], x, list(map(lambda g: g - x, a)))
    return ans
print(main())

