n = int(input())

ss = list(input())
f = 0
s = 0
l = ss[0]
for i in range(1, len(ss)):
    c = ss[i]
    if c == l:
        continue
    if c == 'F':
        f += 1
    else:
        s += 1
    l = c

print("YES") if f > s else print("NO")
