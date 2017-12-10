def main():
    k = int(input())
    if k == 0:
        print("0")
        return
    d = list(map(int,input().split(' ')))
    s = []
    se = set()
    a = set()
    b = set()
    c = set()
    for di in d:
        if di == 0 or di == 100:
            se.add(di)
        else:
            if di < 10:
                a.add(di)
            else:
                if "0" in list(str(di)):
                    b.add(di)
                else:
                    c.add(di)
    if len(a) > 0:
        se.add(list(a)[0])
    if len(b) > 0:
        se.add(list(b)[0])
    if len(a) == 0 and len(b) == 0 and len(c) > 0:
        se.add(list(c)[0])
    print(len(se))
    print(' '.join(list(map(str,sorted(list(se))))))
main()
