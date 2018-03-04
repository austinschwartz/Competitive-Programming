def main(a):
    a = list(str(a))
    for i in range(len(a)):
        if a[i] == '7':
            a[i] = 1
        else:
            a[i] = 0
    ans = 0
    for i in range(len(a)):
        ans = (2 * ans) + a[i]
    p = 1 << len(a)
    return ans + p - 1
print(main(int(input())))
