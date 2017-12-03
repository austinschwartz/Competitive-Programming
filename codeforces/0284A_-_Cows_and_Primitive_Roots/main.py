def f(p):
    ans = 0
    for x in range(1, p):
        good = True
        y = x
        for i in range(1, p - 1):
            if y == 1:
                good = False
                break
            y = (y * x) % p
        if y != 1:
            good = False
        if good:
            ans += 1
    return ans

print(f(int(input())))
