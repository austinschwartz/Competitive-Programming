def main(n, a):
    ret = 0
    for i in range(1, n - 1):
        if a[i - 1] < a[i] and a[i] > a[i + 1]:
            ret += 1
        if a[i - 1] > a[i] and a[i] < a[i + 1]:
            ret += 1
    return ret

print(main(int(input()), list(map(int, input().split(' ')))))
