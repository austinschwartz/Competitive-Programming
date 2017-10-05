def main():
    n = 1
    i = 2
    x = int(input())
    while n < x + 1:
        n += ((i * (i + 1)) // 2)
        i += 1
    print(i - 2)

main()
