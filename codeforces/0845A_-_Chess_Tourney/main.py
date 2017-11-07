def main(n, a):
    for (i, j) in zip(a[:n], list(reversed(a[n:]))):
        if i >= j:
            return "NO"
    return "YES"

print(main(int(input()), sorted(list(map(int, input().split(' '))))))
