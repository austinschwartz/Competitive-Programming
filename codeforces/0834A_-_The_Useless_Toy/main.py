def main(a, b, n):
    ccw = ["^", "<", "v", ">"] * 2
    cw  = ["^", ">", "v", "<"] * 2
    if n % 2 == 0:
        return "undefined"
    n = n % 4
    if b == ccw[(ccw.index(a) + n)]:
        return "ccw"
    elif b == cw[(cw.index(a) + n)]:
        return "cw"
    return "undefined"

print(main(*input().split(' '), int(input())))
