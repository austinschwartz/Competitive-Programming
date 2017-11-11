def main(n, a):
    x = 0
    y = 0
    for i in range(n):
        if a[i] == 'L':
            x -= 1
        elif a[i] == 'R':
            x += 1
        elif a[i] == 'U':
            y += 1
        elif a[i] == 'D':
            y -= 1
    return n - abs(x) - abs(y)
print(main(int(input()), list(input())))
