(r, c1, c2) = map(int, input().split(' '))

def fits(a, b, offset):
    need = bin(a[0]).count("1") + bin(b[0]).count("1")
    for i in range(0, r):
        x =  bin(a[i] ^ (b[i] << offset)).count("1")
        if x != need:
            return False
    return True

l1 = []
for i in range(r):
    l1.append(int(input(), 2))

l2 = []
for i in range(r):
    l2.append(int(input(), 2))

ret = False
for i in range(0, c1):
    if fits(l1, l2, i):
        ret = True
        break

if ret:
    print("Yes")
else:
    print("No")
