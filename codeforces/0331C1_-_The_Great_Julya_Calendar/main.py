m = {}
m[0] = 0

def main(n):
    global m
    if n in m:
        return m[n]
    if n < 0:
        return int(1e13)
    if n < 10:
        return 1

    digs = set()
    t = n
    while t > 0:
        if t % 10 > 0:
            digs.add(t % 10)
        t //= 10
    mi = int(1e13)
    for i in range(9, 0, -1):
        if i in digs:
            mi = min(mi, main(n - i))
            break
    
    m[n] = mi
    return mi

print(main(int(input())))
