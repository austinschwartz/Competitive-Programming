def main():
    (n, x) = map(int, input().split(' '))
    l = []
    r = []
    for i in range(n):
        (li, ri) = map(int, input().split(' '))
        l.append(li)
        r.append(ri)

    cur = 1
    mins = 0
    i = 0
    while i < n:
        li = l[i]
        ri = r[i]
        if li == cur:
            cur += (ri - li + 1)
            mins += (ri - li + 1)
            i += 1
        elif li >= cur + x:
            cur += x
        else:
            mins += 1
            cur += 1
    return mins
print(main())

    
