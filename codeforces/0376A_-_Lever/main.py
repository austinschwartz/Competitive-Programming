def main():
    def f(a):
        x = []
        for i in range(len(a)):
            if a[i] == '=':
                x.append(0)
            else:
                x.append(int((i + 1) * int(a[i])))
        return sum(x)
    s = input().split('^')
    left = list(map(f, [list(reversed(s[0]))]))[0]
    right = list(map(f, [s[1]]))[0]
    if left == right:
        return "balance"
    elif left < right:
        return "right"
    return "left"

print(main())
