def f(a, b, n):
    for i in range(0, 10):
        new_num = a * 10 + i
        if new_num % b == 0:
            a = new_num
            break
    a *= (10 ** (n - 1))
    if a % b == 0:
        return a
    return -1

def main():
    (a, b, n) = map(int, input().split(' '))

    return f(a, b, n)

print(main())

