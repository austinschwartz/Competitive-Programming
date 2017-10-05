(n, m) = map(int, input().split(' '))

r = True
for i in range(n):
    if i % 2 == 0:
        print("#" * m)
    else:
        if r:
            print("." * (m - 1) + "#")
        else:
            print("#" + "." * (m - 1))
        r ^= True
