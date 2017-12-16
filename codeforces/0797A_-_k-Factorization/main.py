def main():
    from math import sqrt
    (n, k) = map(int, input().split(' '))
    nn = n
    kk = k
    l = []
    while k > 1:
        f = False
        for i in range(2, int(sqrt(n)) + 2):
            if n % i == 0:
                l.append(i)
                n //= i
                k -= 1
                f = True
                break
        if not f:
            break
    l.append(n)
    x = 1
    for ll in l:
        if ll == 1:
            return -1
        x *= ll
    if nn != x or len(l) != kk:
        return -1
    return ' '.join(list(map(str, l)))
print(main())

