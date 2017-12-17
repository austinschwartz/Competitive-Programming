def main():
    def f(a, b):
        if a == b:
            return (True, [])
        if a > b:
            return (False, [])
        (f1, x1) = f(2 * a, b)
        if f1:
            return (True, [(2 * a)] + x1)
        (f2, x2) = f(int(str(a) + '1'), b)
        if f2:
            return (True, [int(str(a) + '1')] + x2)
        return (False, [])
    (a, b) = map(int, input().split(' '))
    (f, x) = f(a, b)
    if f:
        x = [a] + x
        print("YES")
        print(len(x))
        print(' '.join(list(map(str, x))))
    else:
        print("NO")
main()
