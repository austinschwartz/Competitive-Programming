def main(n, a, b, c, d):
    w = a + b
    x = a + c
    y = b + d
    z = c + d
    g = 0
    count = 0
    for e in range(1, n + 1):
        cur = w + e
        f = cur - x
        h = cur - y
        i = cur - z
        if f < 1 or h < 1 or i < 1 or f > n or h > n or i > n:
            continue
        #print('{} {} {}\n{} {} {}\n{} {} {}\n'.format(e, a, f, b, g, c, h, d, i))
        count += 1
    return count * n
print(main(*list(map(int, input().split(' ')))))
