def main():
    n = int(input())
    s = {}
    m = 0
    for i in range(n):
        (a, b) = map(int, input().split(' '))
        if (a, b) in s:
            s[(a, b)] += 1
        else:
            s[(a, b)] = 1
        m = max(m, s[(a, b)])
    return m

print(main())
