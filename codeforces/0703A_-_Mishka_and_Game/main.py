def main():
    n = int(input())
    m, c = 0, 0
    for i in range(n):
        (mi, ci) = map(int, input().split(' '))
        if mi > ci:
            m += 1
        elif ci > mi:
            c += 1
    if m == c:
        return "Friendship is magic!^^"
    elif m > c:
        return "Mishka"
    return "Chris"
print(main())
