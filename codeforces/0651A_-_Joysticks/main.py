memo = {}
def f(a, b):
    global memo
    if a <= 0 or b <= 0 or (a == 1 and b == 1):
        return 0
    if (a, b) in memo:
        return memo[(a, b)]
    x = f(a - 2, b + 1)
    y = f(a + 1, b - 2)
    memo[(a, b)] = 1 + max(x, y)
    return memo[(a, b)]

(a, b) = map(int, input().split(' '))
print(f(a, b))

