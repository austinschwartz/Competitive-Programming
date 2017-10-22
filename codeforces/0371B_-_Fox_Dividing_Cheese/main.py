MAX = 1e9 + 7
m = {}
def main():
    global m
    def f(a, b):
        if (a, b) in m:
            return m[(a, b)]
        if a == b:
            return 0
        if a < 0 or b < 0:
            return int(MAX)
        if a < b:
            return f(b, a)
        ret = int(MAX)
        if a % 2 == 0:
            ret = min(ret, 1 + f(a/2, b))
        if a % 3 == 0:
            ret = min(ret, 1 + f(a/3, b))
        if a % 5 == 0:
            ret = min(ret, 1 + f(a/5, b))
        m[(a, b)] = ret
        return ret
    (a, b) = map(int, input().split(' '))
    x = f(a, b)
    if x == MAX:
        return -1
    return x

print(main())
