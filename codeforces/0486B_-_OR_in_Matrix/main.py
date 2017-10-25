def main():
    (n, m) = map(int, input().split(' '))
    B = []
    for i in range(n):
        B.append(list(map(int, input().split(' '))))
    r = []
    c = []
    for i in range(n):
        if len(list(filter(lambda x: x == 1, B[i]))) == len(B[i]):
            r.append(1)
        else:
            r.append(0)
    for j in range(m):
        col = [B[i][j] for i in range(n)]
        if len(list(filter(lambda x: x == 1, col))) == len(col):
            c.append(1)
        else:
            c.append(0)

    A = [[-1 for i in range(m)] for j in range(n)]
    yes = True
    for i in range(n):
        for j in range(m):
            if r[i] == 1 and c[j] == 1:
                A[i][j] = 1
            else:
                A[i][j] = 0
    for i in range(n):
        for j in range(m):
            o = 0
            for k in range(n):
                o |= A[k][j]
            for k in range(m):
                o |= A[i][k]
            if o != B[i][j]:
                print("NO")
                return
    print("YES")
    for i in range(n):
        print(' '.join(list(map(str, A[i]))))
main()
