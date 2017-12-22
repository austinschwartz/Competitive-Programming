def main():
    n = int(input())
    x = []
    p = True
    k = n
    l = 1
    for i in range(n):
        if p:
            x.append(l)
            l += 1
        else:
            x.append(k)
            k -= 1
        p ^= True
    if len(x) > 1 and abs(x[-1] - x[-2]) == 1:
        x = [x.pop(-1)] + x
    if len(x) <= 3 and len(x) > 1:
        x = x[1:]
    print(len(x))
    print(' '.join(list(map(str, x))))
main()
