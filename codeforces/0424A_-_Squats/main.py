def main(n, s):
    stand = len(list(filter(lambda i: i == 'X', s)))
    dif = max(n // 2, stand) - min(n // 2, stand)
    r = 0
    if stand > n // 2:
        r ^= 1
    print(dif)
    for i in range(n):
        if dif <= 0:
            break
        if r == 0 and s[i] == 'x':
            s[i] = 'X'
            dif -= 1
        elif r == 1 and s[i] == 'X':
            s[i] = 'x'
            dif -= 1
    return ''.join(s)
print(main(int(input()), list(input())))
