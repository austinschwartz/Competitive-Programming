def main(n):
    l = []
    if n <= 3:
        l.append(n)
        return l
    if n % 2 == 1:
        l.append(3)
        n -= 3
    if n >= 2:
        l = l + ([2] * (n // 2))
    return l

l = main(int(input()))
print(len(l))
print(' '.join(list(map(str,l))))
