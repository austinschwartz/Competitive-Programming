n = int(input())

x = []
y = []
for i in range(n):
    (xi, yi) = map(int, input().split(' '))
    x.append(xi)
    y.append(yi)

xs = sum(x)
ys = sum(y)

if xs % 2 == 0 and ys % 2 == 0:
    print(0)
elif xs % 2 == 1 and ys % 2 == 1:
    dif = False
    for i in range(n):
        if x[i] % 2 == 0 and y[i] % 2 != 0:
            dif = True
        elif x[i] % 2 != 0 and y[i] % 2 == 0:
            dif = True
        if dif:
            break
    if dif:
        print(1)
    else:
        print(-1)
else:
    print(-1)
