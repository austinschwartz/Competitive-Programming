def main():
    def is_lucky(a):
        return len(list(filter(lambda i: i == '8', str(a)))) > 0
    a = int(input()) + 1
    b = 1
    while not is_lucky(a):
        a += 1
        b += 1
    return b
print(main())
