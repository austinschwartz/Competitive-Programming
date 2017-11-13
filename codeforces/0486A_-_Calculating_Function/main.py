def main(n):
    if n % 2 == 0:
        a = n // 2 * (2 + n) // 2
        b = n // 2 * (-1 + (-n + 1)) // 2
    else:
        a = n // 2 * (2 + (n - 1)) // 2
        b = (n // 2 + 1) * (-1 + (-n)) // 2
    return a + b

print(main(int(input())))
