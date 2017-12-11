def f(n):
    from math import sqrt
    s = set()
    for i in range(1, int(sqrt(n)) + 2):
        if int(n / i) == n // i:
            f = True
            for c in s:
                if i == 0 or n // i == 0:
                    break
                if c % (n // i) != 0:
                    f = False
                    break
            if f and n // i != 0:
                s.add(n // i) 
    for i in range(1, int(sqrt(n)) + 2):
        if n % i == 0:
            f = True
            for c in s:
                if max(c, i) % min(c, i) != 0:
                    f = False
                    break
            if f:
                s.add(i) 
    return ' '.join(list(map(str, reversed(sorted(s)))))

print(f(int(input())))
