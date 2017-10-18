def main():
    n = int(input())
    a = list(map(int, input().split(' ')))
    evens = list(filter(lambda i: a[i] % 2 == 0, list(range(n))))
    odds = list(filter(lambda i: a[i] % 2 != 0, list(range(n))))
    if len(evens) > len(odds):
        return odds[0] + 1
    return evens[0] + 1

print(main())
