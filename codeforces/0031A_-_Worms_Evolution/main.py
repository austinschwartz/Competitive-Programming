def main(n, a):
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if i != j and j != k and i != k:
                    if a[j] + a[k] == a[i]:
                        return '{} {} {}'.format(i + 1, k + 1, j + 1)
    return -1

print(main(int(input()), list(map(int, input().split(' ')))))
