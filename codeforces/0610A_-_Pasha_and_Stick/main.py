def main(a):
    if a % 2 == 1:
        return 0
    if (a // 2) % 2 == 0:
        return a // 4 - 1
    else:
        return a // 4

print(main(int(input())))
