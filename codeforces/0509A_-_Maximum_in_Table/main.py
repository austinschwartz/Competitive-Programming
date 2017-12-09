def f(i, j):
    if i == 1 or j == 1:
        return 1
    return f(i - 1, j) + f(i, j - 1)

n = int(input())
print(f(n, n))
