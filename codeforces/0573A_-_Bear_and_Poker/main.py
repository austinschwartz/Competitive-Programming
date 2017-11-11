def main(n, a):
    for i in range(n):
        while a[i] % 3 == 0 or a[i] % 2 == 0:
            if a[i] % 3 == 0:
                a[i] //= 3
            if a[i] % 2 == 0:
                a[i] //= 2
    for i in range(n - 1):
        if a[i] != a[i + 1]:
            return "No"
    return "Yes"

print(main(int(input()), list(map(int, input().split(' ')))))
